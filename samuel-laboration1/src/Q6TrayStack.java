public class Q6TrayStack {

    SamuelFixedSizeStack<Q6Tray> Trays = new SamuelFixedSizeStack<>(30);

    public Q6TrayStack(int stacks) {
        for (int i = 0; i < stacks; i++) {
            Trays.push(new Q6Tray());
        }
    }

}
