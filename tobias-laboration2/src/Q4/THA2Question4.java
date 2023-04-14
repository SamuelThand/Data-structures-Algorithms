package Q4;

import util.THAVLTree;

public class THA2Question4 {
    private static THAVLTree<Integer> tree = new THAVLTree<>();

    public static void main(String[] args) {
        System.out.println("----- AVL demo 1");
        tree.insert(10);
        tree.insert(13);
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);
        System.out.print("Before rotation.");
        tree.print();
        tree.insert(2);
        System.out.print("After rotation.");
        tree.print();
        System.out.println("Is balanced? " + tree.checkBalance());

        System.out.println("----- AVL demo 2, with find");

        tree.clear();
        tree.insert(10);
        tree.insert(8);
        tree.insert(13);
        tree.insert(12);
        tree.insert(15);
        System.out.print("Before rotation.");
        tree.print();
        tree.insert(18);
        System.out.print("After rotation.");
        tree.print();
        System.out.println("Is balanced? " + tree.checkBalance());
        System.out.println("Find 10, should be true. Result: " + tree.find(10));
        System.out.println("Find 7, should be false. Result: " + tree.find(7));

        System.out.println("------ AVL demo 3, with count");

        tree.insert(1);
        tree.insert(34);
        tree.insert(-7);
        tree.insert(78);
        tree.insert(45);
        tree.insert(67);
        tree.insert(89);
        tree.insert(-6);
        tree.insert(94);
        tree.insert(215261);
        tree.insert(0);
        tree.insert(-4);
        tree.insert(-5);
        tree.insert(90);
        tree.insert(-8);
        tree.insert(23);
        tree.print();
        System.out.println("Is balanced? " + tree.checkBalance());
        System.out.println("count 66, should be 16. Result: " + tree.count(66));
        System.out.println("count 67, should be 16. Result: " + tree.count(67));
        System.out.println("count 68, should be 17. Result: " + tree.count(68));

        System.out.println("------ AVL demo 4, with remove");
        System.out.print("Before remove.");
        tree.print();
        tree.remove(13);
        tree.remove(45);
        tree.remove(15);
        tree.remove(-6);
        tree.remove(0);
        System.out.print("After remove.");
        tree.print();
        System.out.println("Is balanced? " + tree.checkBalance());
    }
}
