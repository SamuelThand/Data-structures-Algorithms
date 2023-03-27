package Q4;

import util.THLinkedList;

/**
 * A queue for customers of question 4, assignment 1.
 */
public class THCustomerQueue {

    private final THLinkedList<THCustomer> expressQueue;
    private final THLinkedList<THCustomer> normalQueue;
    private final int EXPRESS_LIMIT = 5;

    /**
     * Create a new customer queue with one express queue and one normal queue.
     */
    public THCustomerQueue() {
        expressQueue = new THLinkedList<>();
        normalQueue = new THLinkedList<>();
    }

    /**
     * Add a customer to the queue.
     * @param customer customer to add
     */
    public void addCustomer(THCustomer customer) {
        String queueType;
        int queueLength;

        if (customer.groceryAmount() <= EXPRESS_LIMIT) {
            expressQueue.addLast(customer);
            queueType = "express";
            queueLength = expressQueue.size();
        } else {
            normalQueue.addLast(customer);
            queueType = "normal";
            queueLength = normalQueue.size();
        }
        System.out.printf("Customer entered in %s queue and it grew to a length of %d.%n", queueType, queueLength);
    }

    /**
     * Remove a customer from the queue.
     * If express queue is empty, the first customer in the normal queue is moved to the express queue.
     * If normal queue is empty, the first customer in the express queue is moved to the normal queue.
     * @return customer removed from the queue
     */
    public THCustomer removeCustomer() {
        THCustomer customer;
        String queueType;

        // Remove customer from queue, priority to express queue
        if (!expressQueue.isEmpty()) {
            customer = expressQueue.removeFirst();
            queueType = "express";
        } else if (!normalQueue.isEmpty()) {
            customer = normalQueue.removeFirst();
            queueType = "normal";
        } else {
            System.out.println("No customers in queue.");
            return null;
        }
        System.out.printf("Customer %d %s with %d items left the %s queue.%n",
                customer.customerId(), customer.name(), customer.groceryAmount(), queueType);
        System.out.printf("Express queue: %d customers, Normal queue: %d customers.%n",
                expressQueue.size(), normalQueue.size());

        // Migrate customer between queues if one queue is empty
        if (expressQueue.isEmpty() && !normalQueue.isEmpty()) {
            migrateCustomer(normalQueue, expressQueue);
        } else if (normalQueue.isEmpty() && !expressQueue.isEmpty()) {
            migrateCustomer(expressQueue, normalQueue);
        }
        return customer;
    }

    /**
     * Migrate a customer from one queue to another.
     * As we're working with queues, the customer will be removed from the first position in the "from" queue
     * and added to the last position in the "to" queue.
     * @param from migrate customer from
     * @param to migrate customer to
     */
    private void migrateCustomer(THLinkedList<THCustomer> from, THLinkedList<THCustomer> to) {
        THCustomer customer = from.removeFirst();
        to.addLast(customer);
        System.out.printf("Customer %d %s with %d items migrated between queues.%n",
                customer.customerId(), customer.name(), customer.groceryAmount());
    }

    @Override
    public String toString() {
        return "\nTHCustomerQueue contains "
                + expressQueue.size() + " express customers and "
                + normalQueue.size() + " normal customers.\n"
                + "Express queue: \n" + expressQueue
                + "Normal queue: \n" + normalQueue;
    }
}
