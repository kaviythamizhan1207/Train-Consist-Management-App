import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC5 ===");

        // 1. Create a LinkedHashSet<String> to represent the train formation.
        // LinkedHashSet combines the uniqueness of a Set with the ordering of a LinkedList.
        Set<String> trainFormation = new LinkedHashSet<>();

        System.out.println("Attaching bogies to the engine...");

        // 2. Attach bogies: Engine, Sleeper, Cargo, Guard.
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // 3. Attempt to attach a duplicate bogie intentionally (Sleeper again).
        System.out.println("\nAlert: Accidental duplicate attachment detected in yard!");
        boolean isDuplicateAdded = trainFormation.add("Sleeper");

        System.out.println("Attempting to attach duplicate 'Sleeper'... Success: " + isDuplicateAdded);

        // 4. Display the final formation order.
        // The output will show the exact physical attachment sequence, without the duplicate.
        System.out.println("\nFinal Verified Train Formation: ");
        System.out.println(trainFormation);

        System.out.println("\nProgram continues...");
    }
}