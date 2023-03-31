package SamuelDatastructures;

import java.util.EmptyStackException;

public class Q3Stueue<T> {

    private SamuelFixedSizeStack<T> stack1;
    private SamuelFixedSizeStack<T> stack2;

    public Q3Stueue(int size) {
        stack1 = new SamuelFixedSizeStack<>(size);
        stack2 = new SamuelFixedSizeStack<>(size);
    }

    public void push(T item) {
        stack1.push(item);
    }

    public T pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else if (!stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        } else {
            throw new EmptyStackException();
        }

    }

    public T deque() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}