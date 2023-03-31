package Q6;

public class Q6Tray {

    int[][] eggs = new int[10][10];

    public Q6Tray() {
        var idGenerator = new Q6IDGenerator();
//        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                eggs[i][j] = idGenerator.getId();
//                count++;
            }
        }
    }

    public int[][] getEggs() {
        return eggs;
    }
}
