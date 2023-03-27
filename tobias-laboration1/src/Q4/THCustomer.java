package Q4;

public final class THCustomer {
    private final String name;
    private final int customerId;
    private final int groceryAmount;

    public THCustomer(String name, int customerId, int groceryAmount) {
        this.name = name;
        this.customerId = customerId;
        this.groceryAmount = groceryAmount;
    }

    public String name() {
        return name;
    }

    public int customerId() {
        return customerId;
    }

    public int groceryAmount() {
        return groceryAmount;
    }

    @Override
    public String toString() {
        return "THCustomer: " + customerId + ", " +
                "name: " + name + ", " +
                "amount of groceries: " + groceryAmount + ".";
    }
}
