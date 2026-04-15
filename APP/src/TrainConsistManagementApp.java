import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. Create a Bogie class with fields such as name and capacity.
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

    // Overriding toString() allows us to easily print the object later
    @Override
    public String toString() {
        return "Bogie Type: " + name + " | Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC7 ===");

        // 2. Create a List<Bogie> to store passenger bogies.
        List<Bogie> passengerBogies = new ArrayList<>();

        // 3. Add bogies like Sleeper, AC Chair, and First Class with capacities.
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("--- Unsorted Bogies (Insertion Order) ---");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        // 4. Use Comparator.comparingInt() to define sorting based on capacity.
        // We use a method reference (Bogie::getCapacity) to concisely tell Java what value to compare.
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // 5. Display the sorted bogies.
        System.out.println("\n--- Sorted Bogies by Capacity (Ascending) ---");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }

        System.out.println("\nProgram continues...");
    }
}