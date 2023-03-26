package util;

import java.util.EmptyStackException;

/**
 * Generic stack implementation using an array.
 *
 * @param <T> The type of the items in the stack.
 *
 * @author Tobias
 */
public class TobiasStack<T> {
    private T[] itemArray;
    private static final int DEFAULT_SIZE = 10;
    private int arraySize;
    private int top;

    /**
     * Creates a new stack with the specified size.
     *
     * @param size size of the stack
     */
    public TobiasStack(int size) {
        this.arraySize = size;
        this.top = -1;
        this.itemArray = (T[]) new Object[size];
    }

    /**
     * Creates a new stack with the default size.
     */
    public TobiasStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Pushes an item on top of the stack.
     *
     * @param item item to push
     *
     * @return true if the item was pushed, false otherwise
     */
    public boolean push(T item) {
        if (++top >= arraySize) {
            resize();
        }
        itemArray[top] = item;
        return true;
    }

    /**
     * Pops an item from the top of the stack.
     *
     * @return item popped
     *
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return itemArray[top--];
    }

    /**
     * Peeks at the top of the stack.
     *
     * @return item at the top of the stack
     *
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return itemArray[top];
    }

    /**
     * Returns the size of the stack.
     *
     * @return size of the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * Double the array size.
     */
    private void resize() {
        T[] newArray = (T[]) new Object[arraySize * 2];
        for (int i = 0; i < arraySize; i++) {
            newArray[i] = itemArray[i];
        }
        itemArray = newArray;
        arraySize *= 2;
    }
}
