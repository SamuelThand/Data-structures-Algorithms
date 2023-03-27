package Q4;

import java.util.Random;

public class Question4 {
    private static int customerIdCounter = 0;
    private static final Random random = new Random();
    private static final String[] names = {"Tobias", "Erik", "Kalle", "Johan", "Karl", "Gustav", "Göran", "Gunnar",
            "Gösta", "Samuel", "Sven-Sven", "Sven-Samuel", "Sven-Erik", "Sven-Olof", "Sven-Olov", "Sven-Åke", "Sven-Göran",
            "Sven-Gunnar", "Sven-Gösta", "Sven-Gustav", "Sven-Henrik", "Sven-Håkan", "Sven-Johan", "Sven-Karl", "Sven-Tobias"};

    public static void main(String[] args) {
        THCustomerQueue queue = new THCustomerQueue();

        // Create 8 customers and add them to the queue
        for (int i = 0; i < 8; i++) {
            THCustomer customer = new THCustomer(getRandomName(), getCustomerIdCounter(), getRandomGroceryAmount());
            queue.addCustomer(customer);
        }
        // Print the queue
        System.out.println(queue);

        // Remove 8 customers from the queue
        for (int i = 0; i < 8; i++) {
            queue.removeCustomer();
        }
        // Print the queue
        System.out.println(queue);

        // Try to remove non-existing customer
        queue.removeCustomer();

    }

    /**
     * Get a new customer id.
     */
    private static int getCustomerIdCounter() {
        return customerIdCounter++;
    }

    /**
     * Get a random amount of groceries.
     */
    private static int getRandomGroceryAmount() {
        return random.nextInt(24) + 1;
    }

    /**
     * Get a random name from the names array.
     */
    private static String getRandomName() {
        return names[new Random().nextInt(names.length)];
    }
}
