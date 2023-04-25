package SamuelDatastructures;

public class SamuelOpenHashTable {

    private final SLinkedList<String>[] table;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public SamuelOpenHashTable(int size) {
        this.table = (SLinkedList<String>[]) new SLinkedList<?>[size];
        for (int i = 0; i < size; i++)
            this.table[i] = new SLinkedList<>();
        this.currentSize = 0;
    }

    public void add(String word) {
        int index = hash(word);
        if (!this.table[index].contains(word)) {
            this.table[index].insertAtTail(word);
            this.currentSize++;
        }
    }

    public void remove(String word) {
        int index = hash(word);
        if (this.table[index].contains(word)) {
            this.table[index].remove(word);
            this.currentSize--;
        }
    }

    public boolean contains(String word) {
        int index = hash(word);
        return this.table[index].contains(word);
    }

    public int size() {
        return this.currentSize;
    }

    private int hash(String s) {
        int hashCode = s.hashCode();
        int index = hashCode % this.table.length; // Make the index fit into one of the buckets of the table
        return (index < 0) ? index + this.table.length : index; // Makes sure the returned index is positive
    }
}
