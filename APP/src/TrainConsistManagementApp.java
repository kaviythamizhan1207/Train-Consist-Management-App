import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 1. Reusing the Bogie class from UC7
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie Type: " + name + " | Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC8 ===");

        // 2. Create a List<Bogie> to store passenger bogies.
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General Second Class", 90)); // Added to show multiple matches

        System.out.println("--- Original Consist (All Passenger Bogies) ---");
        passengerBogies.forEach(System.out::println); // Using method reference for clean printing

        // 3. Define the condition threshold
        int capacityThreshold = 60;
        System.out.println("\nApplying Stream Filter: Capacity > " + capacityThreshold + "...");

        // 4. Call the modular filtering method
        List<Bogie> highCapacityBogies = filterBogiesByCapacity(passengerBogies, capacityThreshold);

        // 5. Display the filtered bogies.
        System.out.println("\n--- Filtered Consist (High Capacity Only) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies matched the filtering criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        // 6. Verify Original Collection Integrity (testFilter_OriginalListUnchanged)
        System.out.println("\n--- Verification: Original List Size ---");
        System.out.println("Original size: " + passengerBogies.size() + " (Remains unchanged)");

        System.out.println("\nProgram continues...");
    }

    /**
     * Filters a list of bogies based on a minimum capacity threshold.
     * This method is purely functional and does not modify the original list,
     * making it perfectly suited for the JUnit test cases provided.
     *
     * @param bogies    The original list of bogies
     * @param threshold The capacity strictly greater than this value will be included
     * @return A new List containing only the matching bogies
     */
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()                         // Convert list to a sequential stream
                .filter(b -> b.getCapacity() > threshold) // Apply condition using a lambda expression
                .collect(Collectors.toList());            // Collect the matching elements into a NEW list
    }
}