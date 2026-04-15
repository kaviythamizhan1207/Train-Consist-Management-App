import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 1. Reusing the Bogie class from previous use cases
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
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC13 ===");

        // 1. Create a large collection of bogies for testing (testLargeDatasetProcessing)
        int datasetSize = 100_000;
        int threshold = 60;
        System.out.println("Generating a dataset of " + datasetSize + " passenger bogies...");
        List<Bogie> largeTrainConsist = generateLargeDataset(datasetSize);

        // --- Benchmark 1: Traditional Loop-Based Processing ---
        System.out.println("\n--- Benchmarking Loop-Based Filtering ---");
        // 2. Capture start time using System.nanoTime()
        long loopStartTime = System.nanoTime();

        // 3. Execute loop-based filtering
        List<Bogie> loopFiltered = filterUsingLoop(largeTrainConsist, threshold);

        // 4. Capture end time using System.nanoTime()
        long loopEndTime = System.nanoTime();

        // 5. Compute elapsed time
        long loopDuration = loopEndTime - loopStartTime;
        System.out.println("Loop Filter Result Size: " + loopFiltered.size());
        System.out.println("Loop Execution Time: " + loopDuration + " nanoseconds");

        // --- Benchmark 2: Stream-Based Processing ---
        System.out.println("\n--- Benchmarking Stream-Based Filtering ---");
        long streamStartTime = System.nanoTime();

        List<Bogie> streamFiltered = filterUsingStream(largeTrainConsist, threshold);

        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        System.out.println("Stream Filter Result Size: " + streamFiltered.size());
        System.out.println("Stream Execution Time: " + streamDuration + " nanoseconds");

        // --- Consistency Verification (testLoopAndStreamResultsMatch) ---
        System.out.println("\n--- Verification ---");
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("[SUCCESS] Both approaches yielded identical results.");
        } else {
            System.out.println("[ERROR] Results mismatch!");
        }

        System.out.println("\nProgram continues...");
    }

    /**
     * Filters bogies using a traditional imperative loop.
     * Suited for: testLoopFilteringLogic
     */
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filteredList = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > threshold) {
                filteredList.add(bogie);
            }
        }
        return filteredList;
    }

    /**
     * Filters bogies using a declarative Java Stream.
     * Suited for: testStreamFilteringLogic
     */
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    /**
     * Helper method to generate a massive dataset to make performance differences measurable.
     */
    public static List<Bogie> generateLargeDataset(int size) {
        List<Bogie> dataset = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            // Alternating capacities to ensure our filter catches a subset of them
            int capacity = (i % 2 == 0) ? 72 : 56;
            dataset.add(new Bogie("Sleeper-" + i, capacity));
        }
        return dataset;
    }
}