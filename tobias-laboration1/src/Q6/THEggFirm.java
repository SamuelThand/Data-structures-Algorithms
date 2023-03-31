package Q6;

public class THEggFirm {
    private THEggWarehouse[] warehouses;
    private final int LIMIT = 20;

    public THEggFirm() {
        this.warehouses = new THEggWarehouse[LIMIT];
        fillFirm();
    }

    private void fillFirm() {
        for (int i = 0; i < LIMIT; i++) {
            warehouses[i] = new THEggWarehouse();
        }
    }

    public int getEgg(long barcode) {
        long temp;
        int pos;
        temp = barcode % 1000000000000L;
        pos = (int) (temp / 10000000000L);
        if (pos >= LIMIT) {
            System.out.println("Warehouse not found!");
            return -1;
        }
        System.out.println("Getting egg from warehouse " + (pos+1) + ".");
        return warehouses[pos].getEgg(barcode);
    }
}
