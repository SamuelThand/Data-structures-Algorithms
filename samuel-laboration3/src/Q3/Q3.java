package Q3;

import SamuelDatastructures.SLinkedList;
import SamuelDatastructures.SamuelOpenHashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        //Filename
        //first, median, random
        System.out.println(args[0] + " " + args[1]);

        var unsorted = loadNumbers(args[0]);

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

}
