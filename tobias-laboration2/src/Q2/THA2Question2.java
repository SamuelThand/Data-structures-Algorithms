package Q2;

import util.THBinarySearchTree;

public class THA2Question2 {
    public static void main(String[] args) {
        THBinarySearchTree<Character> tree = new THBinarySearchTree<>();
        insert(tree, "621438");

        tree.print();

        tree.insert('5');
        tree.print();

        tree.remove('2');

        tree.print();

        tree.insert('0');
        tree.insert('2');
        tree.insert('7');

        tree.print();
        tree.remove('3');
        tree.print();

    }

    private static void insert(THBinarySearchTree<Character> tree, String word) {
        for (int i = 0; i < word.length(); i++) {
            tree.insert(word.charAt(i));
        }
    }
}
