import java.util.EmptyStackException;

public class SamuelFixedSizeStack<T> {

    T[] items;
    int top;

    @SuppressWarnings("unchecked")
    public SamuelFixedSizeStack(int size) {
        items = (T[]) new Object[size];
        top = 0;
    }

    public void push(T item) throws StackOverflowError {
        if (top >= items.length) {
            System.out.println(items.length);
            throw new StackOverflowError("The stack is full");
        }
        else
            items[top] = item;
            top++;
    }

    public T pop() throws EmptyStackException {
        if (top <= 0)
            throw new EmptyStackException();
        else
            top--;
            T item = items[top];
            items[top] = null;
            return item;
    }

    public T peek() {
        if (top-1 <= 0)
            throw new EmptyStackException();
        else
            return items[top-1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }
}