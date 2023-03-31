public class Q6IDGenerator {

    private static int id = 0;

    public int getId() {
        var nextId = id;
        id++;
        return nextId;
    }
}
