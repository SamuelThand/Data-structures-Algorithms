package Q6;

import java.util.Random;

public class THEggTray {
    private int[][] eggs;

    public THEggTray() {
        this.eggs = new int[10][10];
        fillTray();
    }

    private void fillTray() {
        Random rd = new Random();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                eggs[row][col] = rd.nextInt(0,50000);
            }
        }
    }

    public int getEgg(long barcode) {
        int temp, col, row, egg;
        temp = (int) (barcode % 100);
        row = temp / 10;
        col = temp % 10;
        System.out.println("Getting egg from row " + (row+1) + " and column " + (col+1) + ".");
        egg = eggs[col][row];
        System.out.println("Egg " + egg + " found!");
        return egg;
    }
}
