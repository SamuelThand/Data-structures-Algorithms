package Q5;

import util.THCircularDoublyLinkedList;

import java.util.Scanner;

public class Question5 {
    private static THCircularDoublyLinkedList list;
    private static Scanner scanner;

    public static void main(String[] args) {
        list = new THCircularDoublyLinkedList();
        scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            takeMenuInput();
        }

    }

    private static void displayMenu() {
        System.out.println("\n1. Insert");
        System.out.println("2. Display");
        System.out.println("3. Triplet");
        System.out.println("4. Reverse");
        System.out.println("0. Exit");
    }

    private static void takeMenuInput() {
        int input = promptUser("Enter menu choice:");
        switch (input) {
            case 1 -> {
                int number = promptUser("Enter number to insert:");
                switch (list.insert(number)) {
                    case 0 -> System.out.println("Number " + number + " inserted");
                    case 1 -> System.out.println("List is not sorted in ascending order");
                    case -1 -> System.out.println("Number already exists");
                }
            }
            case 2 -> list.display();
            case 3 -> {
                int number = promptUser("Enter triplet target:");
                switch (list.triplet(number)) {
                    case 1 -> System.out.println("List is not sorted in ascending order");
                    case -1 -> System.out.println("Not enough elements");
                }
            }
            case 4 -> list.reverse();
            case 0 -> {
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println("Invalid input");
        }
    }

    private static int promptUser(String message) {
        System.out.println(message);
        System.out.print("> ");
        if (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid input");
            return promptUser(message);
        } else {
            return scanner.nextInt();
        }
    }
}
