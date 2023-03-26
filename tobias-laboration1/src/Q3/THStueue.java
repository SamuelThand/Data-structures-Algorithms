package Q3;

/**
 * A stueue is a combination of a stack and a queue.
 * @param <T> type of item to hold in the stueue
 */
public class THStueue<T> {
    private THFixedStack<T> stack1;
    private THFixedStack<T> stack2;

    public THStueue(int size) {
        stack1 = new THFixedStack<T>(size);
        stack2 = new THFixedStack<T>(size);
    }

    /**
     * Push an item to the stueue.
     * @param item item to push
     */
    public boolean push(T item) {
        return stack1.push(item);
    }

    /**
     * Return the last item in the stueue.
     * @return last item
     */
    public T pop() {
        return stack1.pop();
    }

    /**
     * Return the first item in the stueue.
     * @return first item
     */
    public T deque() {
        T item;
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        item = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return item;
    }
}
