package util;

public class THOpenHashTable implements THHashTable {
    private int size;
    private final THA3LinkedList<String>[] table;
    public THOpenHashTable(int tableSize) {
        if (tableSize < 1) {
            tableSize = 1;
        }
        table = new THA3LinkedList[tableSize];
        size = 0;
        for (int i = 0; i < tableSize; i++) {
            table[i] = new THA3LinkedList<>();
        }
    }

    @Override
    public boolean add(final String item) {
        THA3LinkedList<String> list = table[hash(item, table.length)];
        if (list.contains(item)) {
            return false;
        }
        list.addLast(item);
        size++;
        return true;
    }

    @Override
    public boolean remove(final String item) {
        THA3LinkedList<String> list = table[hash(item, table.length)];
        if (list.remove(item) != null) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(final String item) {
        THA3LinkedList<String> list = table[hash(item, table.length)];
        return list.contains(item);
    }

    @Override
    public int size() {
        return size;
    }

    private static int hash(final String item, int tableSize) {
        int hash = 0;
        for (int i = 0; i < item.length(); i++) {
            hash = (hash * 37 + item.charAt(i)) % tableSize;
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            sb.append(i).append(": ");
            sb.append(table[i].toString());
            if (i < table.length - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
