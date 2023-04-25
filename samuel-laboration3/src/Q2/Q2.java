package Q2;

import SamuelDatastructures.SLinkedList;
import SamuelDatastructures.SamuelOpenHashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Q2 {

    private static final double hashTableLoadFactor = 0.75;

    public static void main(String[] args) {

        var dictionary = readFile("samuel-laboration3/src/Q2/words");

        int lines = 0;
        var words = new SLinkedList<String>();
        while (dictionary.hasNextLine()) {
            words.insertAtTail(dictionary.nextLine());
            lines++;
        }

        var hashTable = new SamuelOpenHashTable(calculateTableSize(lines)); //TODO appropriate size
        var iterator = words.iterator();
        do
            hashTable.add(iterator.next());
        while (iterator.hasNext());

        System.out.println(hashTable.contains("épée"));
        System.out.println(hashTable.contains("A(E*FJA(_)EJF9a0"));
    }

    public static Scanner readFile(String path) {
        try {
            return new Scanner(new File(path));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return null;
    }

    private static int calculateTableSize(int words) {
        var size = (int) Math.ceil(words / hashTableLoadFactor);
        while (true)
            if (isPrimeNumber(size))
                return size;
            else
                size++;
    }

    private static boolean isPrimeNumber(int number)
    {
        for (int i = 2; i < sqrt(number); i++)
            if (number % i == 0)
                return false;

        return true;
    }



}
