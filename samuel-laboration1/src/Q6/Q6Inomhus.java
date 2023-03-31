package Q6;

public class Q6Inomhus {

    Q6Warehouse[] warehouses = new Q6Warehouse[20];

    public Q6Inomhus() {

        for (int i = 0; i < 20; i++) {
            warehouses[i] = new Q6Warehouse();
        }


    }

    public int getEggId(
            int warehouseNumber,
            int truckNumber,
            int boxNumber,
            int stackNumber,
            int trayNumber,
            int trayRow,
            int trayColumn
    ) {
        return warehouses[warehouseNumber]
                .getTrucks()[truckNumber]
                .getBoxes()[boxNumber]
                .getTrayStacks()[stackNumber]
                .getTrays()[trayNumber]
                .getEggs()[trayRow][trayColumn];
    }

}
