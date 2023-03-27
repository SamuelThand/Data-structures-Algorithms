package util;

/**
 * A circular doubly linked list which has the following properties:
 *
 * - Inserts the value in an ascending order
 * - Can reverse the sorting order (from ascending to descending or vice versa)
 * - No two distinct nodes can be present (no two nodes have the same data)
 * - For a given value x, count triplets in the list that sum up to the given value x. A triplet in the question is the
 *   values of those three nodes in a doubly-linked list whose sum is equal to x.
 *   An example is given below. You have to make a generic code; this means that the values (of DLL and x) can be
 *   different from the ones shown below:
 */
public class THCircularDoublyLinkedList {
    private Node start;
    private int size;

    public THCircularDoublyLinkedList() {
        this.size = 0;
    }

    /**
     * Inserts the value in an ascending order.
     *
     * @param value value to insert
     */
    public int insert(int value) {
        if (start != null && start.data > start.next.data) {
            return 1;
        }
        Node node = new Node(value);
        if (size == 0) {
            start = node;
            start.next = start;
            start.previous = start;
        } else {
            Node current = start;
            while (current.next != start && current.data < value) {
                current = current.next;
            }
            if (current.data == value) {
                return -1;
            } else if (current.data > value) {
                node.next = current;
                node.previous = current.previous;
                current.previous.next = node;
                current.previous = node;
                if (current == start) {
                    start = node;
                }
            } else {
                node.next = current.next;
                node.previous = current;
                current.next.previous = node;
                current.next = node;
            }
        }
        size++;
        return 0;
    }

    /**
     * Displays the list.
     */
    public void display() {
        System.out.println("The current list is:");
        if (size == 0) {
            System.out.println("Empty");
        } else {
            Node current = start;
            do {
                System.out.print(current.data + ", ");
                current = current.next;
            } while (current != start);
            System.out.println();
        }
    }

    /**
     * Counts the number of triplets in the list that sum up to the given value x.
     * @param sum sum of the triplets
     */
    public int triplet(int sum) {
        Node current, first, last, stop;
        if (start.data > start.next.data) {
            return 1;
        } else if (size < 3) {
            return -1;
        } else {
            System.out.println("Triplet summing to " + sum);
            current = start;
            stop = current.previous.previous;
            do {
                first = current.next;
                last = start.previous;
                while (first != last) {
                    if (current.data + first.data + last.data == sum) {
                        System.out.println("(" + current.data + ", " + first.data + ", " + last.data + ")");
                        first = first.next;
                        if (first == last) {
                            break;
                        }
                        last = last.previous;
                    } else if (current.data + first.data + last.data < sum) {
                        first = first.next;
                    } else {
                        last = last.previous;
                    }
                }
                current = current.next;
            } while (current != stop);
        }
        return 0;
    }

    /**
     * Reverses the sorting order.
     */
    public void reverse() {
        if (start == null || start.next == start) {
            return;
        }
        Node last = start.previous;
        start = reverse(start, last, start);
    }

    /**
     * Reverses the list.
     * @param current current node
     * @param last last node
     * @param first first node
     * @return new start node, reversed list
     */
    private Node reverse(Node current, Node last, Node first) {
        if (current == last) {
            Node temp = current.next;
            current.next = current.previous;
            current.previous = temp;
            first.previous = current;
            return current;
        }

        Node nextNode = current.next;
        Node newStart = reverse(current.next, last, first);

        current.next = current.previous;
        current.previous = nextNode;

        if (nextNode == first) {
            nextNode.next = current;
            first.previous = current;
        }

        return newStart;
    }

    private static class Node {
        public int data;
        public Node previous;
        public Node next;

        public Node(int data) {
            this.data = data;

        }
    }
}
