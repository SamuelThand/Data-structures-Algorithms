package Q1;

import util.THBinaryTree;
import util.THMaxHeapValidator;

public class THA3Question1 {

    public static void main(String[] args) {
        THBinaryTree<Integer> tree = new THBinaryTree<>(97);
        THMaxHeapValidator<Integer> validator = new THMaxHeapValidator<>();

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
        System.out.println(validator.isMaxHeap(tree));

        ll.removeLeft();
        ll.removeRight();
        THBinaryTree.Node<Integer> lrr = lr.setRight(4);
        THBinaryTree.Node<Integer> lrl = lr.setLeft(2);

        tree.print();
        System.out.println(validator.isMaxHeap(tree));

        lrr.setItem(1);
        tree.print();
        System.out.println(validator.isMaxHeap(tree));

        l.removeLeft();
        tree.print();
        System.out.println(validator.isMaxHeap(tree));
    }

}
