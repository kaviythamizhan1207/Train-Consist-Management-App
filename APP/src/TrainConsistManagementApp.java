import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC6 ===");

        // 1. Create a HashMap<String, Integer> to store bogie-capacity information.
        // We use the Map interface to define a Key-Value relationship.
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        System.out.println("Registering Bogie Capacities...");

        // 2 & 3. Insert capacity values using the put() method.
        // The Key (String) must be unique. The Value (Integer) is the capacity.
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo (Rectangular)", 50); // Assuming 50 tons for goods

        // 4. Iterate over the map using entrySet().
        // entrySet() returns a Set of Map.Entry objects, allowing us to access both key and value simultaneously.
        System.out.println("\n--- Bogie Capacity Details ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieType = entry.getKey();
            Integer capacity = entry.getValue();

            // 5. Display each bogie along with its corresponding capacity.
            System.out.println("Bogie Type: " + bogieType + " | Capacity: " + capacity);
        }

        // Demonstrating fast lookup (O(1) time complexity)
        System.out.println("\nQuick Lookup Check:");
        System.out.println("Capacity for 'Sleeper' is: " + bogieCapacityMap.get("Sleeper"));

        System.out.println("\nProgram continues...");
    }
}