package Q2;

import util.THA3LinkedList;
import util.THOpenHashTable;

import java.util.Scanner;

public class THA3Question2 {
    public static void main(String[] args) {
//        partOneDemo();
        partTwo();
    }

    private static void partOneDemo() {
        THOpenHashTable hashTable = new THOpenHashTable(5);
        String target = "Dog";
        System.out.println("Adding A: inserted = " + hashTable.add("A"));
        System.out.println("Adding A again: inserted = " + hashTable.add("A"));
        hashTable.add(target);
        hashTable.add("Ball");
        hashTable.add("Cat");
        hashTable.add("Elephant");
        hashTable.add("Elephant123");
        hashTable.add("Elephant12345678");

        System.out.println(hashTable);
        System.out.printf("Size of the hash table is: %d\n", hashTable.size());
        System.out.println("Contains " + target + ": " + hashTable.contains("A"));
        System.out.println("Contains B: " + hashTable.contains("B"));

        System.out.println("Removing Dog: removed = " + hashTable.remove(target));
        System.out.println("Removing Dog again: removed = " + hashTable.remove(target));
        System.out.println(hashTable);
        System.out.printf("Size of the hash table is: %d\n", hashTable.size());
    }

    private static void partTwo() {
        SpellChecker spellChecker = new SpellChecker();
        Scanner in = new Scanner(System.in);
        String line;

        while (true) {
            System.out.print("word: ");
            line = in.nextLine();
            if (line.equals("!quit") || line.equals("!q")) {
                break;
            } else if (line.isEmpty()) {
                continue;
            }
            // Split the line into words and check each word, regex "\\s+" matches one or more whitespace characters
            for (String word : line.split("\\s+")) {
                if (spellChecker.isCorrect(word)) {
                    System.out.println("OK");
                } else {
                    StringBuilder sb = new StringBuilder();
                    THA3LinkedList<String> nearMisses = spellChecker.getNearMisses(word);
                    if (nearMisses.isEmpty()) {
                        System.out.println("Not found.");
                        continue;
                    }
                    sb.append("How about: ");
                    for (String suggestion : nearMisses) {
                        sb.append(suggestion).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                    System.out.println(sb);
                }
            }
        }
        in.close();
    }

}
