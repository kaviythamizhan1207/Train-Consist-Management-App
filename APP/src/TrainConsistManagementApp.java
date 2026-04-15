import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC3 ===");

        // 1. Create a HashSet<String> for bogie IDs.
        // The Set interface ensures no duplicate elements can exist in the collection.
        Set<String> bogieIds = new HashSet<>();

        System.out.println("Registering Bogie IDs for the consist...");

        // 2. Add values, intentionally including a duplicate.
        // We can capture the boolean return value of add() to see if the insertion was successful.
        boolean isBg101Added = bogieIds.add("BG101");
        System.out.println("Attempting to add BG101... Success: " + isBg101Added);

        boolean isBg102Added = bogieIds.add("BG102");
        System.out.println("Attempting to add BG102... Success: " + isBg102Added);

        // Intentionally adding a duplicate ID
        boolean isDuplicateAdded = bogieIds.add("BG101");
        System.out.println("Attempting to add BG101 again... Success: " + isDuplicateAdded);

        boolean isBg103Added = bogieIds.add("BG103");
        System.out.println("Attempting to add BG103... Success: " + isBg103Added);

        // 3. Print the final set to observe the state.
        // Notice that the duplicate "BG101" is completely ignored, and the output order
        // may not match the insertion order because HashSet is unordered.
        System.out.println("\nFinal Registered Unique Bogie IDs: " + bogieIds);
        System.out.println("Program continues...");
    }
}