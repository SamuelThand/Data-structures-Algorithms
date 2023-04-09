package Q3;

import util.THBinarySearchTree;

public class THA2Question3 {

    public static void main(String[] args) {
//        partADemo();
        partBDemo();
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
        insert(tree, "MOTHER");
        tree.print();
        separate("Pre-order iterative", "root -> left child -> right child");
        tree.preOrderTraversal();
        separate("Pre-order recursive", "root -> left child -> right child");
        tree.preOrderTraversalRec();
        tree.print();
        separate("Post-order iterative", "left child -> right child -> root");
        tree.postOrderTraversal();
        separate("Post-order recursive", "left child -> right child -> root");
        tree.postOrderTraversalRec();
        tree.print();
        separate("In-order iterative", "left child -> root -> right child");
        tree.inOrderTraversal();
        separate("In-order recursive", "left child -> root -> right child");
        tree.inOrderTraversalRec();
        tree.print();
        separate("Level-order iterative", "left leaf to right leaf");
        tree.levelOrderTraversal();
        separate("Level-order recursive", "left leaf to right leaf");
        tree.levelOrderTraversalRec();

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
}
