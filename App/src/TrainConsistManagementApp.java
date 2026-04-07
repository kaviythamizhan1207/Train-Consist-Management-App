import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App - Use Case 1
 * Demonstrates basic application initialization, the main method,
 * and dynamic collection creation using ArrayList.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // 1. Print the welcome message
        System.out.println("=== Train Consist Management App ===");

        // 2. Initialize an empty List using ArrayList to store bogies dynamically
        // Note: Using Object type temporarily. This will be replaced by a specific
        // 'Bogie' domain model in upcoming use cases.
        List<Object> trainConsist = new ArrayList<>();

        // 3. Display the initial state and bogie count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial bogie count: " + trainConsist.size());

        System.out.println("Program continues...");
    }
}