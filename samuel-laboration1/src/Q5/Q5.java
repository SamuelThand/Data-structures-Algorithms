package Q5;

import SamuelDatastructures.SamuelCircularDoublyLinkedList;

import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        var list = new SamuelCircularDoublyLinkedList();
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Find Triplets");
            System.out.println("4. Reverse");
            System.out.println("5. Exit");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Value: ");
                    try {
                        list.insert(scanner.nextInt());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }

                }
                case 2 -> list.display();
                case 3 -> {
                    System.out.println("Value to find triplets for: ");
                    try {
                        list.triplet(scanner.nextInt());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e);
                    }
                }
                case 4 -> {
                    list.reverse();
                }
                case 5 -> {
                    scanner.close();
                    System.exit(0);
                }
                default -> {
                }
            }
        }

    }

}
