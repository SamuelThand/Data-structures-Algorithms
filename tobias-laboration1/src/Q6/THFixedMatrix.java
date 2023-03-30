package Q6;

import java.util.Random;

public class THFixedMatrix {
    int[][] content;

    public THFixedMatrix() {
        this.content = new int[10][10];
        fillTray();
    }

    private void fillTray() {
        Random rd = new Random();
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                content[row][col] = rd.nextInt();
            }
        }
    }

    public int getEgg(int colRow) {
        if (colRow > 99) {
            return -1;
        }
        int col, row, egg;

        col = colRow / 10;
        row = colRow % 10;
        egg = content[col][row];
        return egg;
    }
}
