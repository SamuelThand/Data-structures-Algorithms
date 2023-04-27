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

        System.out.println("Welcome to the dictionary. Type 'Q! or q!' to quit.\n");
        while (true) {
            System.out.print("Enter a word: ");
            var enteredWord = userInput.nextLine().trim().toLowerCase();

            if (enteredWord.equals("q!"))
                break;
            else if (enteredWord.isEmpty() || !(enteredWord.matches("[a-z ']+"))) {
                System.out.println("Invalid input");
                continue;
            }

            if (hashTable.contains(enteredWord)) {
                System.out.println("Exists");
                continue;
            }

            var nearMisses = checkNearMisses(enteredWord, hashTable);
            if (!nearMisses.isEmpty()) {
                System.out.println("Did you mean: ");
                var iter = nearMisses.iterator();
                boolean first = true;
                do {
                    if (first)
                        first = false;
                    else
                        System.out.print(", ");
                    System.out.printf("%s", iter.next());
                } while (iter.hasNext());
                System.out.println();
                System.out.println();
            } else
                System.out.println("Not found");
        }
    }

    private static SamuelOpenHashTable loadWords() {
        var dictionary = readFile("samuel-laboration3/src/Q2/words");

        if (dictionary == null || !dictionary.hasNextLine()) {
            System.out.println("Empty file");
            System.exit(1);
        }

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
            System.out.println("File was not found");
            System.exit(1);
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

        // Swap two characters
        if (word.length() > 1) {
            var swapCharVariations = swapChar(word);
            var swapCharIter = swapCharVariations.iterator();
            do {
                var next = swapCharIter.next();
                if (hashTable.contains(next))
                    nearMisses.insertAtTail(next);
            } while (swapCharIter.hasNext());
        }

        // Replace a character
        var replaceCharVariations = replaceChar(word);
        var replaceCharIter = replaceCharVariations.iterator();
        do {
            var next = replaceCharIter.next();
            if (hashTable.contains(next))
                nearMisses.insertAtTail(next);
        } while (replaceCharIter.hasNext());

        // Add a space character
        if (word.length() > 1 && !(word.contains(" "))) {
            var spaceVariations = insertSpace(word);
            var spaceIter = spaceVariations.iterator();
            do {
                var next = spaceIter.next();
                var firstPart = next.split(" ")[0];
                var secondPart = next.split(" ")[1];
                if (hashTable.contains(firstPart))
                    nearMisses.insertAtTail(firstPart);
                if (hashTable.contains(secondPart))
                    nearMisses.insertAtTail(secondPart);
            } while (spaceIter.hasNext());
        }

        return nearMisses;
    }

    private static SLinkedList<String> surplusChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i < word.length(); i++) {
            var variation = word.substring(0, i) + word.substring(i + 1);
            if (!variations.contains(variation))
                variations.insertAtTail(variation);
        }
        return variations;
    }

    private static SLinkedList<String> missingChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i <= word.length(); i++) {
            for (char character = 'a'; character <= 'z'; character++)
                variations.insertAtTail(word.substring(0, i) + character + word.substring(i));

            variations.insertAtTail(word.substring(0, i) + "'" + word.substring(i));
        }

        return variations;
    }

    private static SLinkedList<String> replaceChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char character = 'a'; character <= 'z'; character++)
                variations.insertAtTail(word.substring(0, i) + character + word.substring(i + 1));

        variations.insertAtTail(word.substring(0, i) + "'" + word.substring(i + 1));
        }

        return variations;
    }

    private static SLinkedList<String> swapChar(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 0; i < word.length() - 1; i++) {
            var characters = word.toCharArray();
            var firstChar = characters[i];
            var secondChar = characters[i + 1];
            characters[i] = secondChar;
            characters[i + 1] = firstChar;
            variations.insertAtTail(new String(characters));
        }

        return variations;
    }

    private static SLinkedList<String> insertSpace(String word) {
        var variations = new SLinkedList<String>();
        for (int i = 1; i < word.length(); i++)
                variations.insertAtTail(word.substring(0, i) + " " + word.substring(i));

        return variations;
    }
}
