package Q3;

import util.THBinarySearchTree;

import java.util.Random;

public class THA2Question3 {

    public static void main(String[] args) {
        partADemo();
        partBDemo();
        partB();
    }

    private static void partADemo() {
        THBinarySearchTree<Character> tree = new THBinarySearchTree<>();

        insert(tree, "123");
        tree.print();

        System.out.printf("The tree is balanced: %b\n", tree.checkBalance());

        tree.remove('1');
        tree.insert('1');
        tree.print();
        System.out.printf("The tree is balanced: %b\n", tree.checkBalance());

        System.out.printf("Char 1 is in the tree: %b\n", tree.find('1'));
        System.out.printf("Char 4 is in the tree: %b\n", tree.find('4'));
    }

    private static void partBDemo() {
        THBinarySearchTree<Character> tree = new THBinarySearchTree<>();
        insert(tree, "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
        tree.print();
        separate("Pre-order iterative", "root -> left child -> right child");
        System.out.println(tree.preOrderTraversal());
        separate("Pre-order recursive", "root -> left child -> right child");
        System.out.println(tree.preOrderTraversalRec());
        tree.print();
        separate("Post-order iterative", "left child -> right child -> root");
        System.out.println(tree.postOrderTraversal());
        separate("Post-order recursive", "left child -> right child -> root");
        System.out.println(tree.postOrderTraversalRec());
        tree.print();
        separate("In-order iterative", "left child -> root -> right child");
        System.out.println(tree.inOrderTraversal());
        separate("In-order recursive", "left child -> root -> right child");
        System.out.println(tree.inOrderTraversalRec());
        tree.print();
        separate("Level-order iterative", "left leaf to right leaf");
        System.out.println(tree.levelOrderTraversal());
        separate("Level-order recursive", "left leaf to right leaf");
        System.out.println(tree.levelOrderTraversalRec());
    }

    private static void partB() {
        String[] headers = {
                "pre it", "pre rec", "post it", "post rec", "in it", "in rec", "level it", "level rec"
        };
        THBinarySearchTree<Integer> tree1000000 = generateRandomizedIntegerTree(1000000);
        THBinarySearchTree<Integer> tree100000 = generateRandomizedIntegerTree(100000);
        THBinarySearchTree<Integer> tree10000 = generateRandomizedIntegerTree(10000);
        THBinarySearchTree<Integer> tree1000 = generateRandomizedIntegerTree(1000);
        THBinarySearchTree<Integer> tree100 = generateRandomizedIntegerTree(100);
        THBinarySearchTree<Integer> tree10 = generateRandomizedIntegerTree(10);

//        System.out.println("Warming up...");
//        int counter = 0;
//        while (counter < 5) {
//            counter++;
//            tree1000000.preOrderTraversal();
//        }

        StringBuilder table = new StringBuilder();
        table.append(String.format("%-20s", "Tree size * iter"));
        addTableContent(table, headers);
        table.append(String.format("%-20s", "1000000 * 1"));
        runTests(tree1000000, 1, table);
        table.append(String.format("%-20s", "100000 * 10"));
        runTests(tree100000, 10, table);
        table.append(String.format("%-20s", "10000 * 100"));
        runTests(tree10000, 100, table);
        table.append(String.format("%-20s", "1000 * 1000"));
        runTests(tree1000, 1000, table);
        table.append(String.format("%-20s", "100 * 10000"));
        runTests(tree100, 10000, table);
        table.append(String.format("%-20s", "10 * 100000"));
        runTests(tree10, 100000, table);
        System.out.println(table);
    }

    private static void runTests(final THBinarySearchTree<Integer> tree, final int iterations, StringBuilder table) {
        long preOrderTT = 0;
        long preOrderRecTT = 0;
        long postOrderTT = 0;
        long postOrderRecTT = 0;
        long inOrderTT = 0;
        long inOrderRecTT = 0;
        long levelOrderTT = 0;
        long levelOrderRecTT = 0;

        for (int i = 0; i < iterations; i++) {
            preOrderTT += runTest(tree::preOrderTraversal);
            preOrderRecTT += runTest(tree::preOrderTraversalRec);
            postOrderTT += runTest(tree::postOrderTraversal);
            postOrderRecTT += runTest(tree::postOrderTraversalRec);
            inOrderTT += runTest(tree::inOrderTraversal);
            inOrderRecTT += runTest(tree::inOrderTraversalRec);
            levelOrderTT += runTest(tree::levelOrderTraversal);
            levelOrderRecTT += runTest(tree::levelOrderTraversalRec);
        }
        addTableContent(table, new String[]{
                String.format("%d ns", preOrderTT / iterations),
                String.format("%d ns", preOrderRecTT / iterations),
                String.format("%d ns", postOrderTT / iterations),
                String.format("%d ns", postOrderRecTT / iterations),
                String.format("%d ns", inOrderTT / iterations),
                String.format("%d ns", inOrderRecTT / iterations),
                String.format("%d ns", levelOrderTT / iterations),
                String.format("%d ns", levelOrderRecTT / iterations)
        });
    }

    private static void addTableContent(StringBuilder table, String[] data) {
        for (String s : data) {
            table.append("| ");
            table.append(String.format("%-15s", s));
        }
        table.append("\n");
    }

    private static long runTest(Job job) {
        long start = System.nanoTime();
        job.run();
        return System.nanoTime() - start;
    }

    private static void separate(String message, String note) {
        String line = "-".repeat(10);
        System.out.printf("%s %s %s %s\n", line, message, line, note);
    }

    private static void insert(THBinarySearchTree<Character> tree, String word) {
        for (int i = 0; i < word.length(); i++) {
            tree.insert(word.charAt(i));
        }
    }

    private static THBinarySearchTree<Integer> generateRandomizedIntegerTree(int size) {
        THBinarySearchTree<Integer> tree = new THBinarySearchTree<>();
        Random random = new Random();
        int counter = 0;
        while (counter < size) {
            int value = random.nextInt();
            if (!tree.find(value)) {
                tree.insert(value);
                counter++;
            }
        }
        return tree;
    }

    private interface Job {
        void run();
    }

}
