package Q2;

import util.THBinarySearchTree;

public class THA2Question2 {
    public static void main(String[] args) {
        THBinarySearchTree<Integer> tree = new THBinarySearchTree<>();
        tree.insert(10);
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
        tree.remove(1);
        tree.print();
        tree.remove(11);
        tree.print();

    }
}
