package Q6;

public class THEggStack {
    private THEggTray[] trays;
    private final int LIMIT = 30;

    public THEggStack() {
        this.trays = new THEggTray[LIMIT];
        fillStack();
    }

    private void fillStack() {
        for (int i = 0; i < LIMIT; i++) {
            trays[i] = new THEggTray();
        }
    }

    public int getEgg(long barcode) {
        int temp, pos;
        temp = (int) (barcode % 10000);
        pos = temp / 100;
        if (pos >= LIMIT) {
            System.out.println("Tray not found!");
            return -1;
        }
        System.out.println("Getting egg from tray " + (pos+1) + ".");
        return trays[pos].getEgg(barcode);
    }
}
