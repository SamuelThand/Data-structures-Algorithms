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

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------EXPERIMENT--------------");
        System.out.println();
        System.out.println();
        System.out.println();

        doMeasurement(1_000_000, 10);
        doMeasurement(100_000, 100);
        doMeasurement(10000, 1000);
        doMeasurement(1000, 10000);
        doMeasurement(100, 100_000);
        doMeasurement(10, 1_000_000);
    }

    private static void doMeasurement(int iterations, int treeSize) {

        System.out.printf("TREE SIZE %d - Average times (MS)\n", treeSize);
        System.out.println("-------------------------------------------------");

        var mutedOutput = new PrintStream(OutputStream.nullOutputStream());
        var enabledOutput = System.out;
        var random = new Random();
        var tree = new BSTNode<Integer>(null);
        long t_iterativeInorderTraveral = 0;
        long t_iterativePreorderTraveral = 0;
        long t_iterativePostorderTraveral = 0;
        long t_iterativeLevelorderTraveral = 0;
        long t_recursiveInorderTraveral = 0;
        long t_recursivePreorderTraveral = 0;
        long t_recursivePostorderTraveral = 0;
        long t_recursiveLevelorderTraveral = 0;
        long start = 0;
        long end = 0;
        System.setOut(mutedOutput);
        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < treeSize; j++)
                tree.insert(random.nextInt());

            //Iterative
            start = System.nanoTime();
            tree.iterativeInOrderTraversal();
            end = System.nanoTime();
            t_iterativeInorderTraveral += end - start;

            start = System.nanoTime();
            tree.iterativePreOrderTraversal();
            end = System.nanoTime();
            t_iterativePreorderTraveral += end - start;

            start = System.nanoTime();
            tree.iterativePostOrderTraversal();
            end = System.nanoTime();
            t_iterativePostorderTraveral += end - start;

            start = System.nanoTime();
            tree.iterativeLevelOrderTraversal();
            end = System.nanoTime();
            t_iterativeLevelorderTraveral += end - start;

            //Recursive
            start = System.nanoTime();
            tree.recursiveInOrderTraversal();
            end = System.nanoTime();
            t_recursiveInorderTraveral += end - start;

            start = System.nanoTime();
            tree.recursivePreOrderTraversal();
            end = System.nanoTime();
            t_recursivePreorderTraveral += end - start;

            start = System.nanoTime();
            tree.recursivePostOrderTraversal();
            end = System.nanoTime();
            t_recursivePostorderTraveral += end - start;

            start = System.nanoTime();
            tree.recursiveLevelOrderTraversal();
            end = System.nanoTime();
            t_recursiveLevelorderTraveral += end - start;

            tree.clear();
        }
        System.setOut(enabledOutput);

        System.out.println("Iterative\n");
        System.out.print("In-order: " + t_iterativeInorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Pre-order: " + t_iterativePreorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Post-order: " + t_iterativePostorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Level-order: " + t_iterativeLevelorderTraveral/iterations/1_000_000.0 + " ");
        System.out.println();
        System.out.println();
        System.out.println("Recursive\n");
        System.out.print("In-order: " + t_recursiveInorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Pre-order: " + t_recursivePreorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Post-order: " + t_recursivePostorderTraveral/iterations/1_000_000.0 + " ");
        System.out.print("Level-order: " + t_recursiveLevelorderTraveral/iterations/1_000_000.0 + " ");
        System.out.println();
        System.out.println();
    }
}

