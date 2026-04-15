import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC2 ===");

        // 1. Create an ArrayList<String> for passenger bogies.
        // Using String type temporarily to represent the bogies.
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class.
        // The add() method appends elements in the order they are inserted.
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion.
        System.out.println("Initial Passenger Bogies attached: " + passengerBogies);

        // 4. Remove one bogie (AC Chair).
        System.out.println("\nDetaching 'AC Chair' bogie...");
        passengerBogies.remove("AC Chair");

        // 5. Use contains() to check if Sleeper exists.
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Safety Check: Is the 'Sleeper' bogie still attached? " + hasSleeper);

        // 6. Print final list state.
        System.out.println("\nFinal Consist State: " + passengerBogies);
        System.out.println("Program continues...");
    }
}