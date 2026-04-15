import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC4 ===");

        // 1. Create a LinkedList<String> for the consist.
        // We use the concrete class LinkedList here instead of the List interface
        // to gain access to specific deque methods like removeFirst() and removeLast().
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add bogies: Engine, Sleeper, AC, Cargo, Guard.
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Formation: " + trainConsist);

        // 3. Insert a Pantry Car at position 2.
        // In a LinkedList, this requires traversing to index 2 and adjusting the node pointers,
        // rather than shifting a massive underlying array.
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter attaching 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // 4. Remove the first and last bogie.
        System.out.println("\nDetaching Locomotive (First) and Guard Coach (Last)...");
        String removedEngine = trainConsist.removeFirst();
        String removedGuard = trainConsist.removeLast();

        System.out.println("Detached: " + removedEngine);
        System.out.println("Detached: " + removedGuard);

        // 5. Display the final ordered train consist.
        System.out.println("\nFinal Consist State: " + trainConsist);
        System.out.println("Program continues...");
    }
}