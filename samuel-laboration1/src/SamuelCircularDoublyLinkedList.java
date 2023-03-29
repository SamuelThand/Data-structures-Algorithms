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
        } else {
            var currentNode = this.head;

            while (currentNode.getItem() < item && currentNode.getNextNode() != this.head) {
                currentNode = currentNode.getNextNode();
            }

            if (isDuplicate(currentNode, item))
                throw new IllegalArgumentException("This number already exists in the list");

            else if (currentNode.getItem() > item) {
                if (currentNode == this.head)
                    this.head = node;
                else
                    currentNode.getPreviousNode().setNextNode(node);

                //relinking
                node.setPreviousNode(currentNode.getPreviousNode());
                node.setNextNode(currentNode);
                currentNode.setPreviousNode(node);

            // The item is the largest one yet
            } else {


                //?
            }





        }


    }

    private boolean isDuplicate(Node<Integer> node, int item) {
        return node.getItem() == item;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

}
