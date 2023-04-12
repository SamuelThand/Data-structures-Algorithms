package Q4;

import SamuelDatastructures.AVLTreeNode;

import java.util.Random;

public class Q4 {

    public static void main(String[] args) {


        var random = new Random();
        var tree = new AVLTreeNode<>(0);

        System.out.println("Inserting 50 random numbers");
        for (int i = 0; i < 50; i++) {
            tree = tree.insert(random.nextInt());
        }

        tree.print();

        System.out.println("Tree is balanced: " + tree.isBalanced());

        System.out.println("inserting 30");
        tree = tree.insert(30);

        System.out.println("Finding 30: " + tree.find(30));

        System.out.println("Adding numbers 1-100");
        for (int i = 1; i < 101; i++) {
            tree = tree.insert(i);
        }

        tree.print();
        System.out.println("Tree is balanced: " + tree.isBalanced());

        System.out.println("Removing 40 - 70");
        for (int i = 40; i < 71; i++) {
            tree = tree.remove(i);
        }

        tree.print();
        System.out.println("Tree is balanced: " + tree.isBalanced());

        //TODO Answer B


    }

}
