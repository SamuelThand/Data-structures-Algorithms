package Q3;

import SamuelDatastructures.Q3Stueue;

public class Q3 {

    public static void main(String[] args) {

        var stueue = new Q3Stueue<Integer>(8);

        System.out.println("Pushing 1, 2, 3, 4, 5, 6, 7, 8");
        stueue.push(1);
        stueue.push(2);
        stueue.push(3);
        stueue.push(4);
        stueue.push(5);
        stueue.push(6);
        stueue.push(7);
        stueue.push(8);

        System.out.println("Popping:");
        System.out.println(stueue.pop());
        System.out.println(stueue.pop());
        System.out.println(stueue.pop());

        System.out.println("Dequeing:");
        System.out.println(stueue.deque());
        System.out.println(stueue.deque());
        System.out.println(stueue.deque());

        System.out.println("Pushing 9");
        stueue.push(9);

        System.out.println("Dequeuing:");
        System.out.println(stueue.deque());

        System.out.println("Popping:");
        System.out.println(stueue.pop());

        System.out.println("Popping:");
        System.out.println(stueue.pop());

    }

}
