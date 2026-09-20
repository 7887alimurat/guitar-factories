# Guitar Shop — Factory Method & Abstract Factory (Java)

Software Design Patterns · Assignment #2 · Domain: **guitars** (continues the Builder assignment topic).

## How to run
```bash
mkdir out
javac -d out $(find src -name "*.java")
java -cp out app.Main
```
(Windows PowerShell: `javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName`)

## Project structure
```
src/
├── validation/       Validation.java              (shared guard methods)
├── factorymethod/    PART A
│   ├── Guitar                 <- Product (interface)
│   ├── AcousticGuitar, ElectricGuitar, BassGuitar   <- Concrete Products (3, required ≥ 2)
│   ├── GuitarMaker            <- Creator (abstract, declares createGuitar())
│   └── AcousticGuitarMaker, ElectricGuitarMaker, BassGuitarMaker  <- Concrete Creators
├── abstractfactory/  PART B
│   ├── Guitar (reused), Amplifier, GuitarCase       <- Abstract Products
│   ├── Vintage*  (Guitar, Amplifier, GuitarCase)    <- family 1
│   ├── Modern*   (Guitar, Amplifier, GuitarCase)    <- family 2
│   ├── GuitarFamilyFactory    <- Abstract Factory (3 creation methods)
│   ├── VintageFamilyFactory, ModernFamilyFactory    <- Concrete Factories
│   └── GuitarKitClient        <- Client (never uses `new` on a concrete product)
└── app/              Main, FactoryMethodDemo, AbstractFactoryDemo
```

## Part A — Factory Method: requirements checklist
| Component | Requirement | Where |
|---|---|---|
| Product | interface with common contract | `Guitar` |
| Concrete Product | ≥ 2 | `AcousticGuitar`, `ElectricGuitar`, `BassGuitar` |
| Creator | abstract class with factory method | `GuitarMaker.createGuitar()` |
| Concrete Creator | ≥ 2, each producing one product | `AcousticGuitarMaker`, `ElectricGuitarMaker`, `BassGuitarMaker` |

**Idea:** `GuitarMaker` contains business logic (`orderGuitar`, `issueReceipt`) that works with *any* `Guitar`. Only the subclass decides which concrete class is created.

## Part B — Abstract Factory: requirements checklist
| Component | Requirement | Where |
|---|---|---|
| Abstract Products | one interface per product type | `Guitar`, `Amplifier`, `GuitarCase` |
| Concrete Products | ≥ 2 families | Vintage family and Modern family (3 products each) |
| Abstract Factory | one method per product type | `GuitarFamilyFactory` |
| Concrete Factories | ≥ 2, full consistent sets | `VintageFamilyFactory`, `ModernFamilyFactory` |
| Client | only abstract types | `GuitarKitClient` |

**Idea:** the Vintage factory can only give a vintage guitar + tube amp + tweed case; it is impossible to accidentally mix a Vintage guitar with a Modern amp.

**Factory Method vs Abstract Factory (for the defense):** Factory Method = *one* product, variation through subclassing of the creator. Abstract Factory = a *family* of related products, variation through swapping the whole factory object. Abstract Factory is often implemented with several factory methods (`createGuitar()`, `createAmplifier()`, …).

---

## Clean Code principles applied (7)

### 1. Meaningful, intention-revealing names
`GuitarMaker.issueReceipt(modelName)` says what it does; the name of a variable says what it holds.
```java
// BEFORE                                   // AFTER
Object make(String s, int t) {...}          Guitar orderGuitar(String modelName) {...}
```
*Why:* the reader understands the code without comments (Clean Code, Ch. 2–3).

### 2. Small methods that do one thing
```java
// BEFORE: one method creates, validates, prints and formats
void doAll(String name) { if (name == null) {...} Guitar g = new ...; System.out.println(...); }

// AFTER (GuitarMaker): every method has one job
public Guitar orderGuitar(String modelName) { return createGuitar(modelName); }
public String issueReceipt(String modelName) {
    Guitar guitar = orderGuitar(modelName);
    return "Receipt: " + guitar.describe();
}
```

### 3. No magic numbers / magic strings
```java
// BEFORE
public int getStringCount() { return 7; }

// AFTER (ModernGuitar)
private static final int STRING_COUNT = 7;
public int getStringCount() { return STRING_COUNT; }
```
The same is done for wattage (`POWER_WATTS`), names (`NAME`) and sound descriptions (`SOUND`).

### 4. Validated construction (fail fast)
```java
// BEFORE: invalid object silently created
public AcousticGuitar(String modelName) { this.modelName = modelName; }

// AFTER
public AcousticGuitar(String modelName) {
    this.modelName = Validation.requireNonBlank(modelName, "modelName");
}
```
`new AcousticGuitarMaker().orderGuitar("  ")` throws `IllegalArgumentException: modelName must not be null or blank` (shown in the demo output).

### 5. Don't Repeat Yourself (DRY) — one shared validation class
```java
// BEFORE: the same if-throw block copy-pasted in every constructor
if (modelName == null || modelName.isBlank()) throw new IllegalArgumentException("...");

// AFTER: one reusable helper, `Validation.requireNonBlank(...)`, used everywhere
```
Also `Guitar.describe()` is a `default` method, so the text "name (N strings)" is written once, not in every guitar.

### 6. Small, focused classes (Single Responsibility)
Each class has exactly one reason to change: `VintageAmplifier` only knows about the vintage amplifier; `GuitarKitClient` only assembles a kit; `Main` only starts the demos; printing lives in `*Demo` classes, not in the domain.
```java
// BEFORE: one giant GuitarShop class creating everything with if/else
if (type.equals("acoustic")) {...} else if (type.equals("electric")) {...}

// AFTER: one small class per concept + polymorphism (no if/else on type)
new ElectricGuitarMaker().orderGuitar("Stratosphere S-1");
```

### 7. Program to interfaces & consistent formatting
The client depends on abstractions only, and all files follow the same formatting (4-space indentation, one class per file, braces on the same line, blank line between methods).
```java
// BEFORE: client depends on concrete classes
VintageGuitar g = new VintageGuitar(); VintageAmplifier a = new VintageAmplifier();

// AFTER (GuitarKitClient)
Guitar guitar = factory.createGuitar();
Amplifier amplifier = factory.createAmplifier();
```

## Commit history
```
git log --oneline
```
1. Part A: Guitar product interface and concrete products
2. Part A: GuitarMaker creator, concrete creators and demo
3. Part B: Abstract Factory with Vintage and Modern families and client
4. Docs + validation demo (README with Clean Code section)
