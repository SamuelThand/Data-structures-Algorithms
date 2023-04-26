package Q2;

import util.THOpenHashTable;

public class THA3Question2 {
    public static void main(String[] args) {
        partOneDemo();
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
}
