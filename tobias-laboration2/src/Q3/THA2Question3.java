package Q3;

import util.THBinarySearchTree;

public class THA2Question3 {

    public static void main(String[] args) {
        THBinarySearchTree<Character> tree = new THBinarySearchTree<>();

    }

    private static void insert(THBinarySearchTree<Character> tree, String word) {
        for (int i = 0; i < word.length(); i++) {
            tree.insert(word.charAt(i));
        }
    }
}
