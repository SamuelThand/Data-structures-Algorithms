public class Q6Inomhus {

    Q6Warehouse[] warehouses = new Q6Warehouse[20];

    public Q6Inomhus() {

        for (int i = 0; i < 20; i++) {
            warehouses[i] = new Q6Warehouse();
        }


    }

    public int getEggId() {
        return 1;
    }

}
