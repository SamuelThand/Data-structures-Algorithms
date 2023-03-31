package Q6;

public class THEggTruck {
    private THEggBox[] boxes;
    private final int LIMIT = 100;

    public THEggTruck() {
        this.boxes = new THEggBox[LIMIT];
        fillTruck();
    }

    private void fillTruck() {
        for (int i = 0; i < LIMIT; i++) {
            boxes[i] = new THEggBox();
        }
    }

    public int getEgg(long barcode) {
        int temp, pos;
        temp = (int) (barcode % 100000000);
        pos = temp / 1000000;
        if (pos >= LIMIT) {
            System.out.println("Box not found!");
            return -1;
        }
        System.out.println("Getting egg from box " + (pos+1) + ".");
        return boxes[pos].getEgg(barcode);
    }
}
