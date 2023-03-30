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
                eggs[row][col] = rd.nextInt();
            }
        }
    }

    public int getEgg(int barcode) {
        int temp, col, row, egg;
        temp = barcode % 100;
        col = temp / 10;
        row = temp % 10;
        System.out.println("Getting egg from row " + row + " and column " + col + ".");
        egg = eggs[col][row];
        System.out.println("Egg " + egg + " found!");
        return egg;
    }
}
