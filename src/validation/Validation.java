package validation;

/**
 * Small reusable guard methods. Every constructor in the project uses them,
 * so invalid objects can never be created (Clean Code: validated construction, no duplication).
 */
public final class Validation {

    private Validation() {
        // utility class - no instances
    }

    public static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
        return value.trim();
    }

    public static <T> T requireNonNull(T value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
        return value;
    }
}
