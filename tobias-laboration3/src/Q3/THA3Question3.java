package Q3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class THA3Question3 {

    private static final boolean PRINT_ARRAY = false;
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new RuntimeException("""
                    Invalid number of arguments.
                    Usage: <file> <sort type>
                    Sort types: first, median, last""");
        }
        QuickSorter sorter = new QuickSorter();
        String filePath = "tobias-laboration3/src/util/" + args[0];
        String sortType = args[1];
        int comparisons;

        int[] array = loadNumberFromFile(filePath);
        if (array.length <= 100 && PRINT_ARRAY) {
            System.out.println("Unsorted array: " + Arrays.toString(array));
        }

        switch (sortType) {
            case "first" -> comparisons = sorter.quicksortFirst(array);
            case "median" -> comparisons = sorter.quicksortMedian(array);
            case "last" -> comparisons = sorter.quicksortRandom(array);
            default -> throw new RuntimeException("Invalid sort type.");
        }

        if (array.length <= 100 && PRINT_ARRAY) {
            System.out.println("Sorted array: " + Arrays.toString(array));
        }

        System.out.println("Comparisons: " + comparisons);

    }

    private static int[] loadNumberFromFile(String filePath) {
        int[] array;
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            int size = scanner.nextInt();
            array = new int[size];
            int index = 0;
            while (scanner.hasNextInt()) {
                array[index++] = scanner.nextInt();
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read file.\n" + e.getMessage());
        }
        return array;
    }
}
