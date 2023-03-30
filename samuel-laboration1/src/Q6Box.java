public class Q6Box {

    Q6TrayStack[] trayStacks = new Q6TrayStack[6];

    public Q6Box() {
        for (int i = 0; i < 6; i++) {
            trayStacks[i] = new Q6TrayStack(30);
        }
    }

}
