package Q3;

import util.THFixedStack;
import util.THStueue;

public class Question3 {

    public static void main(String[] args) {
        System.out.println("Part A, implementing a fixes size stack.");
        THFixedStack<Integer> stack = new THFixedStack<Integer>(2);
        System.out.println("Item 1 and 2 is pushed to the stack.");
        stack.push(1);
        stack.push(2);
        System.out.println("The stack holds " + stack.size() + " items and full() gives: " + stack.full());
        System.out.println("On the top lies popped item: " + stack.pop() + " and empty() gives: " + stack.empty());
        System.out.println("On the top lies popped item: " + stack.pop() + " and empty() gives: " + stack.empty());

        System.out.println("Part B, implementing a stueue.");
        THStueue<Integer> stueue = new THStueue<Integer>(4);
        System.out.println("Item 1, 2, 3 and 4 is pushed to the stueue.");
        for (int i = 1; i < 5; i++) {
            stueue.push(i);
        }
        System.out.println("Using deque() to get the first item in the stueue: " + stueue.deque());
        System.out.println("Using pop() to get the last item in the stueue: " + stueue.pop());
    }
}
