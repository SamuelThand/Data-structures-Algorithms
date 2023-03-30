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

    public int getEgg(int barcode) {
        int 
    }
}
