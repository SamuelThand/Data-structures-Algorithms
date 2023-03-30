public class Q6Tray {

    Q6Egg[][] eggs = new Q6Egg[10][10];

    public Q6Tray() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                eggs[i][j] = new Q6Egg(count);
                count++;
            }
        }
    }

}
