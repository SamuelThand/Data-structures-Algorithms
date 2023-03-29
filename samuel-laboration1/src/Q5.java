public class Q5 {

    public static void main(String[] args) {
        var list = new SamuelCircularDoublyLinkedList();
        list.insert(3);
        list.insert(6);
        list.insert(9);
        list.insert(15);
        list.insert(12);
        list.insert(18);
        list.display();

        list.reverse();

        list.display();
    }

}
