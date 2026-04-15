import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // 1. Compile patterns using the Pattern class.
    // Compiling these at the class level ensures they are only compiled once, which is a performance best practice.
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC11 ===");

        // Test Scenarios based on your Flow
        String validTrainId = "TRN-1234";
        String invalidTrainId = "TRAIN12";

        String validCargoCode = "PET-AB";
        String invalidCargoCode = "PET-ab"; // Lowercase, should fail

        System.out.println("--- Validating Train IDs ---");
        displayValidationResult("Train ID", validTrainId, isValidTrainId(validTrainId));
        displayValidationResult("Train ID", invalidTrainId, isValidTrainId(invalidTrainId));

        System.out.println("\n--- Validating Cargo Codes ---");
        displayValidationResult("Cargo Code", validCargoCode, isValidCargoCode(validCargoCode));
        displayValidationResult("Cargo Code", invalidCargoCode, isValidCargoCode(invalidCargoCode));

        System.out.println("\nProgram continues...");
    }

    /**
     * Validates if the provided Train ID exactly matches the format: TRN-####
     * This method is pure and perfectly suited for your JUnit test cases.
     *
     * @param trainId The input Train ID to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidTrainId(String trainId) {
        // Handle null or empty inputs gracefully (testRegex_EmptyInputHandling)
        if (trainId == null || trainId.trim().isEmpty()) {
            return false;
        }

        // 2. Create Matcher objects for user input.
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);

        // 3. Use matches() to validate exact input formats (testRegex_ExactPatternMatch).
        return matcher.matches();
    }

    /**
     * Validates if the provided Cargo Code exactly matches the format: PET-XX
     * Only uppercase letters are permitted for the suffix.
     *
     * @param cargoCode The input Cargo Code to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.trim().isEmpty()) {
            return false;
        }

        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        return matcher.matches();
    }

    // Helper method to keep console output clean
    private static void displayValidationResult(String type, String input, boolean isValid) {
        if (isValid) {
            System.out.println("[ACCEPTED] " + type + " '" + input + "' is formatted correctly.");
        } else {
            System.out.println("[REJECTED] " + type + " '" + input + "' failed validation constraints!");
        }
    }
}