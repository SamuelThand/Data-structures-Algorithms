package Q1;

import SamuelDatastructures.BSTNode;

public class Q1 {

    public static void main(String[] args) {

//
//        var tree = new BSTNode<>(97);
//
//        tree.insert(46);
//        tree.insert(12);
//        tree.insert(6);
//        tree.insert(9);
//        tree.insert(3);
//        tree.insert(37);
//        tree.insert(38);
//        tree.insert(31);
//        tree.insert(32);
//
//        tree.print();

//        TODO Maxheap kan inte byggas med denna datastrukturen, gör en modifierad som kan



        var tree = new BSTNode<>(50);

        tree.insert(48);
        tree.insert(52);
        tree.insert(46);
        tree.insert(49);
        tree.insert(51);
        tree.insert(53);
        System.out.println("Not a max heap, the tree is complete but each node is not >= its child");
        tree.print();
        System.out.println(tree.isMaxHeap());


    }

}
