package SamuelDatastructures;

public class Q4CustomerQueue {

    private final SamuelLinkedList<Q4Customer> regularQueue;
    private final SamuelLinkedList<Q4Customer> expressQueue;

    public Q4CustomerQueue() {
        regularQueue = new SamuelLinkedList<>();
        expressQueue = new SamuelLinkedList<>();
    }

    public void addCustomer(Q4Customer customer) {
        boolean isExpress = customer.itemsPurchased() <= 5;
        if (isExpress) {
            expressQueue.add(customer);
            System.out.printf("Customer %d: %s with %d items entered the express queue as number %d.\n",
                    customer.customerID(),
                    customer.name(),
                    customer.itemsPurchased(),
                    expressQueue.size());
        } else {
            regularQueue.add(customer);
            System.out.printf("Customer %d: %s with %d items entered the regular queue as number %d.\n",
                    customer.customerID(),
                    customer.name(),
                    customer.itemsPurchased(),
                    regularQueue.size());
        }
    }

    public Q4Customer removeCustomer() {

        Q4Customer customerRemoved = null;
        if (!expressQueue.isEmpty()) {
            customerRemoved = expressQueue.removeHead();
            System.out.printf("Customer %d: %s with %d items left the express queue, %d customers left in this queue.\n",
                    customerRemoved.customerID(),
                    customerRemoved.name(),
                    customerRemoved.itemsPurchased(),
                    expressQueue.size());
        }
        else if (!regularQueue.isEmpty()) {
            customerRemoved = regularQueue.removeHead();
            System.out.printf("Customer %d: %s with %d items left the regular queue, %d customers left in this queue.\n",
                    customerRemoved.customerID(),
                    customerRemoved.name(),
                    customerRemoved.itemsPurchased(),
                    regularQueue.size());
        }

        if (customerRemoved != null) {
            if (expressQueue.isEmpty()) {
                reassignCustomer(expressQueue, regularQueue);
            } else if (regularQueue.isEmpty()) {
                reassignCustomer(regularQueue, expressQueue);
            }
        }

        return customerRemoved;
    }

    private void reassignCustomer(SamuelLinkedList<Q4Customer> newQueue, SamuelLinkedList<Q4Customer> oldQueue) {
        newQueue.add(oldQueue.removeHead());
    }

    public void printCustomersInfo() {
        System.out.println("Express queue:");
        for (Q4Customer customer : expressQueue) {
            System.out.printf("%s: %s - %d items\n", customer.customerID(), customer.name(), customer.itemsPurchased());
        }
        System.out.println("Regular queue:");
        for (Q4Customer customer : regularQueue) {
            System.out.printf("%s: %s - %d items\n", customer.customerID(), customer.name(), customer.itemsPurchased());
        }
    }
}
