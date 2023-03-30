public class Q6Truck {

    Q6Box[] boxes = new Q6Box[100];

    public Q6Truck(int boxes) {
        for (int i = 0; i < boxes; i++) {
            this.boxes[i] = new Q6Box();
        }
    }

}
