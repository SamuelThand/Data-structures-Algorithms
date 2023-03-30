public class SamuelCircularDoublyLinkedList {

    private Node<Integer> head;
    private Node<Integer> tail;
    private boolean isReversed;

    public SamuelCircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.isReversed = false;
    }

    public void insert(int item) throws IllegalArgumentException {

        if (this.isReversed)
            throw new IllegalArgumentException("Can't insert - the list is reversed.");

        else if (itemExists(item))
            throw new IllegalArgumentException("This number already exists in the list");

        var node = new Node<>(item);

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            node.setNextNode(node);
            node.setPreviousNode(node);
        } else {
            var currentNode = this.head;
            while (currentNode.getItem() < item && currentNode.getNextNode() != this.head) {
                currentNode = currentNode.getNextNode();
            }

            if (currentNode.getItem() > item) {
                if (currentNode == this.head) {
                    this.head = node;
                    this.tail.setNextNode(node);
                } else
                    currentNode.getPreviousNode().setNextNode(node);

                node.setPreviousNode(currentNode.getPreviousNode());
                node.setNextNode(currentNode);
                currentNode.setPreviousNode(node);

            } else {
                node.setPreviousNode(this.tail);
                node.setNextNode(this.head);
                this.head.setPreviousNode(node);
                this.tail.setNextNode(node);
                this.tail = node;
            }
        }
    }

    public void reverse() {
        if (isEmpty() || containsOneItem()) {
            System.out.println("List contains one item, nothing to reverse");
        } else {
            var formerHead = this.head;
            this.head = reverseNodes(this.head, this.tail);
            this.tail = formerHead;

            this.isReversed = !this.isReversed;
            System.out.println("List has been reversed.");

        }
    }

    private Node<Integer> reverseNodes(Node<Integer> current, Node<Integer> previous) {

        var next = current.getNextNode();
        current.setNextNode(previous);
        current.setPreviousNode(next);

        if (next == this.head) {
            return current;
        }

        return reverseNodes(next, current);
    }

    public void triplet(int targetValue) {
        if (this.isReversed)
            throw new IllegalArgumentException("Can't find triplets - the list is reversed.");

        Node<Integer> start, current, end;
        start = this.head;
        current = this.head.getNextNode();
        end = this.tail;

        while (!(current == end)) {
            while (!(current == end)) {
                while (current.getItem() < end.getItem()) {
                    if (start.getItem() + current.getItem() + end.getItem() == targetValue)
                        System.out.printf("(%d, %d, %d)", start.getItem(), current.getItem(), end.getItem());
                    current = current.getNextNode();
                }
                start = start.getNextNode();
                current = start.getNextNode();
            }
            start = this.head;
            current = this.head.getNextNode();
            end = end.getPreviousNode();
        }

        System.out.println();
    }

    public void display() {
        if (isEmpty())
            System.out.println("Empty");
        else {
            var currentNode = this.head;
            System.out.println("List contents:");
            do {
                System.out.print(currentNode.getItem());
                if (this.tail != currentNode)
                    System.out.print(", ");
                currentNode = currentNode.getNextNode();
            } while (currentNode != this.head);
            System.out.println();
        }
    }


    public boolean itemExists(int item) {
        if (isEmpty())
            return false;

        var currentNode = this.head;
        do {
            if (currentNode.getItem() == item)
                return true;
            currentNode = currentNode.getNextNode();
        } while (currentNode != this.head);

        return false;
    }

    private boolean containsOneItem() {
        return this.head.getNextNode() == this.head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

}
