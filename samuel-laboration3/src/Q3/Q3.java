package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(args[0] + " " + args[1]);

        var unsorted = loadNumbers(args[0]);
        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        var sorted = switch (args[1]) {
            case "first" -> quickSortFirst(unsorted,0,unsorted.length - 1);
            case "median" -> quickSortMedian(unsorted,0,unsorted.length - 1);
            case "random" -> quickSortRandom(unsorted,0,unsorted.length - 1);
            default -> null;
        };

        System.out.println("Sorted: " + Arrays.toString(sorted));

    }

    private static int[] loadNumbers(String path) {
        var file = readFile(path);
        if (!file.hasNextLine()) {
            System.out.println("Empty file");
            System.exit(1);
        }

        var numbers = new int[file.nextInt()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = file.nextInt();

        return numbers;
    }

    public static Scanner readFile(String path) {
        try {
            return new Scanner(new File(path));

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
            System.exit(1);
        }

        return null;
    }

    public static int[] quickSortFirst(int[] numbers, int leftIndex, int rightIndex) {

        // Base case - if false, the subarray has been sorted.
        if (leftIndex < rightIndex) {

            //Divide and conquer - Find the next pivot index by partitioning, then recursively sort the parts split at the pivot.
            int pivot = partition(numbers, leftIndex, rightIndex);
            quickSortFirst(numbers, leftIndex, pivot - 1); // First part
            quickSortFirst(numbers, pivot + 1, rightIndex); // Second part
        }

        return numbers; // Sorted array
    }

    public static int[] quickSortMedian(int[] unsorted, int leftIndex, int rightIndex) {
        return unsorted;
    }

    public static int[] quickSortRandom(int[] unsorted, int leftIndex, int rightIndex) {
        return unsorted;
    }

//    TODO measure operations
    private static int partition(int[] numbers, int leftIndex, int rightIndex) {


        int pivot = numbers[leftIndex];
        int newPivot = leftIndex;
        for (int i = leftIndex + 1; i <= rightIndex; i++) {

            // Check if the current element is smaller than the pivot, if so - increment the new pivot and swap the elements.
            // This will move all elements smaller than the pivot, to before the pivot, making the pivot element sorted.
            if (numbers[i] < pivot) {
                newPivot++;
                swap(numbers, newPivot, i);
            }
        }
        swap(numbers, leftIndex, newPivot);

        return newPivot;
    }

    //Swap the item of the first index, with the item of the second index.
    private static void swap(int[] numbers, int firstIndex, int secondIndex) {
        var temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }

}
