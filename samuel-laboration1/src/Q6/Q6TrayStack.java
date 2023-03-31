package Q6;

public class Q6TrayStack {

    Q6Tray[] Trays = new Q6Tray[30];

    public Q6TrayStack(int stacks) {
        for (int i = 0; i < stacks; i++) {
            Trays[i] = new Q6Tray();
        }
    }

    public Q6Tray[] getTrays() {
        return Trays;
    }
}
