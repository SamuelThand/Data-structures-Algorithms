package Q6;

public class THEggWarehouse {
    private THEggTruck[] trucks;
    private final int LIMIT = 15;

    public THEggWarehouse() {
        this.trucks = new THEggTruck[LIMIT];
        fillWarehouse();
    }

    private void fillWarehouse() {
        for (int i = 0; i < LIMIT; i++) {
            trucks[i] = new THEggTruck();
        }
    }

    public int getEgg(long barcode) {
        int temp, pos;
        temp = (int) (barcode % 10000000000L);
        pos = temp / 100000000;
        if (pos >= LIMIT) {
            System.out.println("Truck not found!");
            return -1;
        }
        System.out.println("Getting egg from truck " + (pos+1) + ".");
        return trucks[pos].getEgg(barcode);
    }
}
