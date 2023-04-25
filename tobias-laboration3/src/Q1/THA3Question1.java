package Q1;

import util.THBinaryTree;
import util.THMaxHeapValidator;

public class THA3Question1 {

    public static void main(String[] args) {
        THBinaryTree<Integer> tree = new THBinaryTree<>(97);
        THMaxHeapValidator<Integer> validator = new THMaxHeapValidator<>();

//        Max heap
//        -  -  31
//        -  37
//        -  -  7
//        97
//        -  -  3
//        -  46
//        -  -  -  9
//        -  -  12
//        -  -  -  6
        THBinaryTree.Node<Integer> root = tree.root;
        THBinaryTree.Node<Integer> l = root.setLeft(46);
        THBinaryTree.Node<Integer> r = root.setRight(37);
        THBinaryTree.Node<Integer> ll = l.setLeft(12);
        THBinaryTree.Node<Integer> lr = l.setRight(3);
        THBinaryTree.Node<Integer> lll = ll.setLeft(6);
        THBinaryTree.Node<Integer> llr = ll.setRight(9);
        THBinaryTree.Node<Integer> rl = r.setLeft(7);
        THBinaryTree.Node<Integer> rr = r.setRight(31);
        tree.print();
        validator.isMaxHeap(tree);

//        -  -  31
//        -  37
//        -  -  7
//        97
//        -  -  -  4 Violation
//        -  -  3
//        -  -  -  2 Violation
//        -  46
//        -  -  12

        ll.removeLeft();
        ll.removeRight();
        THBinaryTree.Node<Integer> lrr = lr.setRight(4);
        THBinaryTree.Node<Integer> lrl = lr.setLeft(2);
        tree.print();
        validator.isMaxHeap(tree);

//        -  -  31 Violation
//        -  37
//        97
//        -  46
//        -  -  12
        l.removeRight();
        r.removeLeft();
        tree.print();
        validator.isMaxHeap(tree);

//        Max heap
//        -  37
//        97
//        -  46
//        -  -  4
        r.removeRight();
        tree.print();
        validator.isMaxHeap(tree);

//        97
        root.removeRight();
        root.removeLeft();
        tree.print();
        validator.isMaxHeap(tree);

//        Max heap
//        97
//        -  46
        root.setLeft(46);
        tree.print();
        validator.isMaxHeap(tree);

//        -  37 Violation
//        97
        root.removeLeft();
        root.setRight(37);
        tree.print();
        validator.isMaxHeap(tree);

//        Max heap
//        -  37
//        97
//        -  46
        root.setLeft(46);
        tree.print();
        validator.isMaxHeap(tree);
    }

}
