package Q2;

import util.THBinaryTree;

public class THA2Question2 {
    private static THBinaryTree<String> tree;
    public static void main(String[] args) {
        tree = new THBinaryTree<>();
        tree.insert("C");
        tree.compareToRoot("A");
        tree.compareToRoot("E");
    }
}
