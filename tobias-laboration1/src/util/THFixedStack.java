package util;

import java.util.EmptyStackException;

public class THFixedStack<T> {
    private final T[] itemArray;
    private static final int DEFAULT_SIZE = 10;
    private final int arraySize;
    private int top;

    /**
     * Creates a new stack with the specified size.
     *
     * @param size size of the stack
     */
    public THFixedStack(int size) {
        this.arraySize = size;
        this.top = -1;
        this.itemArray = (T[]) new Object[size];
    }

    /**
     * Creates a new stack with the default size.
     */
    public THFixedStack() {
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
            throw new StackOverflowError();
        }
        itemArray[top] = item;
        return true;
    }

    /**
     * Pops an item from the top of the stack.
     *
     * @return item popped
     *
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException {
        if (empty()) {
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
    public T top() throws EmptyStackException {
        if (empty()) {
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
    public boolean empty() {
        return top < 0;
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean full() {
        return size() >= arraySize;
    }
}
