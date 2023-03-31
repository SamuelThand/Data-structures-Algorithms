public class Q6Warehouse {

    Q6Truck[] trucks = new Q6Truck[15];

    public Q6Warehouse() {
        for (int i = 0; i < 15; i++) {
            trucks[i] = new Q6Truck(100);
        }
    }

    public Q6Truck[] getTrucks() {
        return trucks;
    }
}
