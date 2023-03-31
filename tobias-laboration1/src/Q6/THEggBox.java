package Q6;

public class THEggBox {
    private THEggStack[] stacks;
    private final int LIMIT = 6;

    public THEggBox() {
        this.stacks = new THEggStack[LIMIT];
        fillBox();
    }

    private void fillBox() {
        for (int i = 0; i < LIMIT; i++) {
            stacks[i] = new THEggStack();
        }
    }

    public int getEgg(long barcode) {
        int temp, pos;
        temp = (int) (barcode % 1000000);
        pos = temp / 10000;
        if (pos >= LIMIT) {
            System.out.println("Stack not found!");
            return -1;
        }
        System.out.println("Getting egg from stack " + (pos+1) + ".");
        return stacks[pos].getEgg(barcode);
    }
}
