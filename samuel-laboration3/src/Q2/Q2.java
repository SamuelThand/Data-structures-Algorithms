package Q2;

import SamuelDatastructures.SLinkedList;
import SamuelDatastructures.SamuelOpenHashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {


//        var dictionary = readFile("samuel-laboration3/src/Q2/words");
        var dictionary = readFile("samuel-laboration3/src/Q2/shortwords");

        int lines = 0;
        var words = new SLinkedList<String>();
        while (dictionary.hasNextLine()) {
            words.insertAtTail(dictionary.nextLine());
            lines++;
        }

        var hashTable = new SamuelOpenHashTable(100000);
        var iterator = words.iterator();
        do
//            System.out.println(iterator.next());
            hashTable.add(iterator.next());
//            System.out.println(iterator.next());

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

}
