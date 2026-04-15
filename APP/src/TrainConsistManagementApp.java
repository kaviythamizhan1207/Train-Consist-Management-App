import java.util.ArrayList;
import java.util.List;

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
        return "[Bogie: " + name + " | Seats: " + capacity + "]";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC10 ===");

        // 2. Create a list of passenger bogies.
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General Second Class", 90));

        System.out.println("--- Current Passenger Consist ---");
        passengerBogies.forEach(System.out::println);

        // 3. Perform the aggregation
        System.out.println("\nCalculating total seating capacity using Stream map() and reduce()...");
        int totalSeats = calculateTotalCapacity(passengerBogies);

        // 4. Display the total seating capacity.
        System.out.println("\n*** TOTAL TRAIN SEATING CAPACITY: " + totalSeats + " seats ***");

        // 5. Verify Original Collection Integrity (testReduce_OriginalListUnchanged)
        System.out.println("\n--- Verification: Original List Integrity ---");
        System.out.println("Original list size: " + passengerBogies.size() + " (Remains unchanged)");

        System.out.println("\nProgram continues...");
    }

    /**
     * Calculates the total capacity of a list of bogies.
     * This method is pure, does not modify the original list, and safely handles empty collections,
     * making it perfectly suited for the required JUnit test cases.
     *
     * @param bogies The list of bogies to aggregate.
     * @return The total sum of all bogie capacities.
     */
    public static int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                // Step A: Transform the stream of Bogie objects into a stream of Integers (Capacity)
                .map(b -> b.getCapacity())
                // Step B: Aggregate the integers.
                // 0 is the identity (starting value). Integer::sum is the accumulator function.
                .reduce(0, Integer::sum);
    }
}