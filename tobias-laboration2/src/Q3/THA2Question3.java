package Q3;

import util.THBinarySearchTree;

public class THA2Question3 {

    public static void main(String[] args) {
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

    private static void insert(THBinarySearchTree<Character> tree, String word) {
        for (int i = 0; i < word.length(); i++) {
            tree.insert(word.charAt(i));
        }
    }
}
