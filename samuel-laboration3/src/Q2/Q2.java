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

        var hashTable = loadWords();
        var userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a word: ");

            var enteredWord = userInput.nextLine().toLowerCase();
            var nearMisses = checkNearMisses(enteredWord, hashTable);

            if (hashTable.contains(enteredWord))
                System.out.println("Exists");

            else if (!nearMisses.isEmpty()) {

                var iter = nearMisses.iterator();
                do
                    System.out.println(iter.next());
                while (iter.hasNext());
            }

            else
                System.out.println("Not exist");
        }
    }

    private static SamuelOpenHashTable loadWords() {
        var dictionary = readFile("samuel-laboration3/src/Q2/words");

        int lines = 0;
        var words = new SLinkedList<String>();
        while (dictionary.hasNextLine()) {
            words.insertAtTail(dictionary.nextLine().toLowerCase());
            lines++;
        }

        var hashTable = new SamuelOpenHashTable(calculateTableSize(lines));
        var iterator = words.iterator();
        do
            hashTable.add(iterator.next());
        while (iterator.hasNext());

        return hashTable;
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

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i < sqrt(number); i++)
            if (number % i == 0)
                return false;

        return true;
    }

    private static SLinkedList<String> checkNearMisses(String word, SamuelOpenHashTable hashTable) {
        var nearMisses = new SLinkedList<String>();

        // Remove 1 character
        var surplusCharVariations = surplusChar(word);
        var surplusCharIter = surplusCharVariations.iterator();
        do {
           var next = surplusCharIter.next();
           if (hashTable.contains(next))
               nearMisses.insertAtTail(next);
        } while (surplusCharIter.hasNext());

        // Add 1 character
        var missingCharVariations = missingChar(word);
        var missingCharIter = missingCharVariations.iterator();
        do {
            var next = missingCharIter.next();
            if (hashTable.contains(next))
                nearMisses.insertAtTail(next);
        } while (missingCharIter.hasNext());


        return nearMisses;
    }

    private static SLinkedList<String> surplusChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i < word.length(); i++)
            variations.insertAtTail(word.substring(0, i) + word.substring(i + 1));
        return variations;
    }

    private static SLinkedList<String> missingChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i <= word.length(); i++)
            for (char character = 'a'; character <= 'z'; character++) {
                variations.insertAtTail(word.substring(0, i) + character + word.substring(i));
            }

        return variations;
    }



}
