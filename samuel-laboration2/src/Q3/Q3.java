package Q3;

import SamuelDatastructures.BSTNode;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

public class Q3 {

    public static void main(String[] args) {

        //demoa alla metoder, implementera task B

        System.out.println("Inserting 10, 1, 8, 9, 6, 7, 5, 12, 11, 20, 18, 19, 16, 17\n");

        var tree = new BSTNode<>(10);
        tree.insert(1);
        tree.insert(8);
        tree.insert(9);
        tree.insert(6);
        tree.insert(7);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(20);
        tree.insert(18);
        tree.insert(19);
        tree.insert(16);
        tree.insert(17);

        tree.print();
        System.out.printf("Balanced: %s\n", tree.isBalanced());
        System.out.printf("Height: %s\n", tree.getHeight());
        System.out.println();

        System.out.println("Iterative Level order traversal:");
        tree.iterativeLevelOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Recursive Level order traversal:");
        tree.recursiveLevelOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Iterative Pre order traversal:");
        tree.iterativePreOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Recursive Pre order traversal:");
        tree.recursivePreOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Iterative postorder traversal:");
        tree.iterativePostOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Recursive postorder traversal:");
        tree.recursivePostOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Iterative inorder traversal:");
        tree.iterativeInOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Recursive inorder traversal:");
        tree.recursiveInOrderTraversal();
        System.out.println();
        System.out.println();

        System.out.println("Finding 20:");
        System.out.println(tree.find(20));
        System.out.println();

        System.out.println("Finding 30:");
        System.out.println(tree.find(30));
        System.out.println();

        // Kör igenom alla traversals med 10, 100, 1000, 10000, 100k, 1mil
        // random siffror

        // Kör varje metoderna med 10, 100, 1000 size tusen gånger var och ta fram snittet

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------EXPERIMENT--------------");
        System.out.println();
        System.out.println();
        System.out.println();


        var testingTree10 = new BSTNode<Integer>(null);
        var testingTree100 = new BSTNode<Integer>(null);
        var testingTree1000 = new BSTNode<Integer>(null);
        var testingTree10000 = new BSTNode<Integer>(null);
        var testingTree100000 = new BSTNode<Integer>(null);
        var testingTree1000000 = new BSTNode<Integer>(null);

        var random = new Random();
        var mutedOutput = new PrintStream(OutputStream.nullOutputStream());
        var enabledOutput = System.out;

        //Testing size 10
        System.setOut(mutedOutput);
        long t_iterativeInorderTraveral = 0;
        long start = 0;
        long end = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++)
                testingTree10.insert(random.nextInt());

            start = System.nanoTime();
            testingTree10.iterativeInOrderTraversal();
            end = System.nanoTime();

            t_iterativeInorderTraveral += end - start;
            testingTree10.clear();
        }
        System.setOut(enabledOutput);

        System.out.println("LIST SIZE 10 - Average times (MS)\n");
        System.out.println("Iterative\n");
//        System.out.print("In-order: " + t_iterativeInorderTraveral/1000);
        System.out.print("In-order: " + t_iterativeInorderTraveral);

    }
}

