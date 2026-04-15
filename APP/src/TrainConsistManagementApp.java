import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 1. Reusing the Bogie class
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
        return "[Bogie: " + name + ", Capacity: " + capacity + "]";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC9 ===");

        // 2. Create a list of bogies, intentionally adding multiples of the same type
        // to demonstrate grouping behavior (testGrouping_MultipleBogiesInSameGroup).
        List<Bogie> trainConsist = new ArrayList<>();
        trainConsist.add(new Bogie("Sleeper", 72));
        trainConsist.add(new Bogie("Sleeper", 72));       // 2nd Sleeper
        trainConsist.add(new Bogie("AC Chair", 56));
        trainConsist.add(new Bogie("First Class", 24));
        trainConsist.add(new Bogie("Cargo (Goods)", 50));
        trainConsist.add(new Bogie("Cargo (Goods)", 80)); // 2nd Cargo

        System.out.println("--- Flat List (Uncategorized) ---");
        System.out.println("Total Bogies: " + trainConsist.size());

        // 3. Call the modular grouping method
        System.out.println("\nApplying Stream Collectors.groupingBy()...");
        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(trainConsist);

        // 4. Display the structured, grouped result
        System.out.println("\n--- Grouped Bogies Structured Report ---");
        if (groupedBogies.isEmpty()) {
            System.out.println("No bogies to group.");
        } else {
            // Iterate over the Map entries to show categories and their lists
            groupedBogies.forEach((category, bogieList) -> {
                System.out.println("Category: " + category + " (Count: " + bogieList.size() + ")");
                for (Bogie b : bogieList) {
                    System.out.println("   -> " + b);
                }
            });
        }

        // 5. Verify Original Collection Integrity (testGrouping_OriginalListUnchanged)
        System.out.println("\n--- Verification: Original List Integrity ---");
        System.out.println("Original list size: " + trainConsist.size() + " (Remains unchanged)");

        System.out.println("\nProgram continues...");
    }

    /**
     * Groups a list of bogies by their type/name.
     * This method is pure and does not modify the original list, making it
     * ideal for the required JUnit test cases.
     *
     * @param bogies The flat list of bogies to be grouped.
     * @return A Map where the key is the Bogie name and the value is a List of matching Bogies.
     */
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                // The groupingBy collector uses the classifier function (Bogie::getName)
                // to determine the map keys. It automatically aggregates matching elements into a List.
                .collect(Collectors.groupingBy(Bogie::getName));
    }
}