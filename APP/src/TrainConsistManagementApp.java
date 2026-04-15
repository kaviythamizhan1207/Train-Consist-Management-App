import java.util.ArrayList;
import java.util.List;

// 1. Create a specific class for Goods Bogies with shape and cargo fields.
class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape, String cargo) {
        this.shape = shape;
        this.cargo = cargo;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "[Shape: " + shape + " | Cargo: " + cargo + "]";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC12 ===");

        // --- Scenario 1: A Valid, Safe Train Formation ---
        List<GoodsBogie> safeTrain = new ArrayList<>();
        safeTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        safeTrain.add(new GoodsBogie("Rectangular", "Coal"));
        safeTrain.add(new GoodsBogie("Open", "Steel"));

        System.out.println("--- Verifying Train 1 (Safe Formation) ---");
        safeTrain.forEach(System.out::println);
        boolean isTrain1Safe = isSafetyCompliant(safeTrain);
        displaySafetyResult(isTrain1Safe);

        // --- Scenario 2: An Invalid, Unsafe Train Formation ---
        List<GoodsBogie> unsafeTrain = new ArrayList<>();
        unsafeTrain.add(new GoodsBogie("Rectangular", "Grain"));
        unsafeTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        unsafeTrain.add(new GoodsBogie("Cylindrical", "Coal")); // SAFETY VIOLATION! Coal in a cylindrical bogie.

        System.out.println("\n--- Verifying Train 2 (Unsafe Formation) ---");
        unsafeTrain.forEach(System.out::println);
        boolean isTrain2Safe = isSafetyCompliant(unsafeTrain);
        displaySafetyResult(isTrain2Safe);

        System.out.println("\nProgram continues...");
    }

    /**
     * Validates whether the entire train formation complies with safety rules.
     * Rule: Cylindrical bogies must ONLY carry Petroleum.
     * This method is pure and perfectly suited for your JUnit test cases.
     *
     * @param bogies The list of goods bogies to check.
     * @return true if ALL bogies pass the safety check, false otherwise.
     */
    public static boolean isSafetyCompliant(List<GoodsBogie> bogies) {
        return bogies.stream()
                // allMatch evaluates every element. If even one returns false, the whole expression is false.
                .allMatch(bogie -> {
                    // Conditional Logic: If it is Cylindrical, cargo MUST be Petroleum.
                    if (bogie.getShape().equalsIgnoreCase("Cylindrical")) {
                        return bogie.getCargo().equalsIgnoreCase("Petroleum");
                    }
                    // For non-cylindrical bogies (like Rectangular, Open), any cargo is allowed.
                    return true;
                });
    }

    // Helper method to keep console output clean
    private static void displaySafetyResult(boolean isSafe) {
        if (isSafe) {
            System.out.println(">>> RESULT: [SAFE] Train is compliant and ready for departure.");
        } else {
            System.out.println(">>> RESULT: [UNSAFE] Compliance violation detected! Train formation rejected.");
        }
    }
}