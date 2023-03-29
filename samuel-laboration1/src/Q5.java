public class Q5 {

    public static void main(String[] args) {
        var list = new SamuelCircularDoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(8);
        list.insert(9);

        list.triplet(17);

        // Icke fungerande testcase som ska returnera (1,2,3)
//        list.insert(2);
//        list.insert(7);
//        list.insert(4);
//        list.insert(0);
//        list.insert(9);
//        list.insert(5);
//        list.insert(1);
//        list.insert(3);
//
//        list.triplet(6);



//        list.insert(1);
//        list.insert(2);
//        list.insert(3);
//        list.insert(4);
//        list.insert(5);
//        list.insert(6);
//
//        list.triplet(6);

    }

}
