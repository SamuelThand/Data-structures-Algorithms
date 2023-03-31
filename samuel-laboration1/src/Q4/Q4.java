package Q4;

import SamuelDatastructures.Q4Customer;
import SamuelDatastructures.Q4CustomerQueue;

public class Q4 {
    public static void main(String[] args) {

        var queue = new Q4CustomerQueue();

        System.out.println("Adding customers");
        queue.addCustomer(new Q4Customer("Jonny", 1, 5));
        queue.addCustomer(new Q4Customer("Ralf", 2, 4));
        queue.addCustomer(new Q4Customer("Benny", 4, 3));
        queue.addCustomer(new Q4Customer("Erik", 5, 3400));
        queue.addCustomer(new Q4Customer("Max", 6, 77));
        queue.addCustomer(new Q4Customer("Rune", 7, 954));
        System.out.println();

        System.out.println("Customers info:\n");
        queue.printCustomersInfo();
        System.out.println();

        System.out.println("Removing 1 customer:\n");
        queue.removeCustomer();
        System.out.println();

        System.out.println("Customers info:\n");
        queue.printCustomersInfo();
        System.out.println();

        System.out.println("Removing 2 customer:\n");
        queue.removeCustomer();
        queue.removeCustomer();
        System.out.println();

        System.out.println("Customers info: (Note that Erik has been relocated to the express queue)\n");
        queue.printCustomersInfo();
        System.out.println();
    }
}
