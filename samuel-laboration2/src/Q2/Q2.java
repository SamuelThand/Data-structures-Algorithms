package Q2;

import SamuelDatastructures.BSTNode;

public class Q2 {

    public static void main(String[] args) {

        System.out.println("Trees:\n");

        var tree = new BSTNode<>('M');
        tree.insert('O');
        tree.insert('T');
        tree.insert('H');
        tree.insert('E');
        tree.insert('R');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());

        tree.clear();

        tree.insert('T');
        tree.insert('H');
        tree.insert('E');
        tree.insert('R');
        tree.insert('M');
        tree.insert('O');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());

        tree.clear();

        tree.insert('E');
        tree.insert('H');
        tree.insert('M');
        tree.insert('O');
        tree.insert('R');
        tree.insert('T');

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());


        var tree2 = new BSTNode<>(10);
        tree2.insert(1);
        tree2.insert(8);
        tree2.insert(9);
        tree2.insert(6);
        tree2.insert(7);
        tree2.insert(5);
        tree2.insert(12);
        tree2.insert(11);
        tree2.insert(20);
        tree2.insert(18);
        tree2.insert(19);
        tree2.insert(16);
        tree2.insert(17);

        System.out.println("\nTree 2:");
        tree2.print();
        System.out.printf("Balanced: %s\n", tree2.isBalanced());
        System.out.printf("Height: %s\n", tree2.getHeight());

        System.out.println("\nDeleting 1:");
        tree2 = tree2.remove(1);
        tree2.print();

        System.out.println("\nDeleting 12:");
        tree2 = tree2.remove(12);
        tree2.print();

        System.out.println("\nDeleting 16:");
        tree2 = tree2.remove(16);
        tree2.print();

        System.out.println("\nDeleting 17:");
        tree2 = tree2.remove(17);
        tree2.print();

    }
}