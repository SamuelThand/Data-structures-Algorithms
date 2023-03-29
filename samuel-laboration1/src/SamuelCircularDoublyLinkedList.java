public class SamuelCircularDoublyLinkedList {

    private Node<Integer> head;
    private Node<Integer> tail;

    public SamuelCircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int item) throws IllegalArgumentException {
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

            if (nodeIsDuplicate(currentNode, item))
                throw new IllegalArgumentException("This number already exists in the list");

            else if (currentNode.getItem() > item) {
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
        Node<Integer> start, current, end;

        start = this.head;
        current = this.head.getNextNode();
        end = this.tail;

        do {
            do {
                do {
                    int sum = start.getItem() + current.getItem() + end.getItem();
                    if (sum == targetValue)
                        System.out.printf("(%d, %d, %d)", start.getItem(), current.getItem(), end.getItem());
                    current = current.getNextNode();
                } while (current.getItem() < end.getItem());

                start = start.getNextNode();
                current = start.getNextNode();

            } while (start != end.getPreviousNode().getPreviousNode() && current != end.getPreviousNode());

            start = this.head;
            current = this.head.getNextNode();
            end = end.getPreviousNode();

        } while (!(start == this.head && current == this.head.getNextNode() && end == this.head.getNextNode().getNextNode())); //TODO den sista görs inte? 1, 2, 3

//        System.out.println();
//
//        int sum = start.getItem() + current.getItem() + end.getItem();
//        if (sum == targetValue)
//            System.out.printf("(%d, %d, %d)", start.getItem(), current.getItem(), end.getItem());
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


    private boolean nodeIsDuplicate(Node<Integer> node, int item) {
        return node.getItem() == item;
    }

    private boolean containsOneItem() {
        return this.head.getNextNode() == this.head;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

}
