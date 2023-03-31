package Q2;

import SamuelDatastructures.SamuelFixedSizeStack;

import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter a string with an expression of nested parenthesis:");
        String expression = scanner.nextLine();
        scanner.close();

        SamuelFixedSizeStack<Object> currentDepth = new SamuelFixedSizeStack<>(expression.length());

        int maxDepth = 0;
        try {
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '(')
                    currentDepth.push(new Object());
                    if (currentDepth.size() > maxDepth)
                        maxDepth++;

                else if (expression.charAt(i) == ')')
                    currentDepth.pop();
            }

            if (currentDepth.size() != 0)
                throw new InputMismatchException();

            System.out.printf("The depth of nested parenthesis: %d", maxDepth);
        } catch (EmptyStackException e) {
            System.out.println("The expression has more right parenthesis then left parenthesis");
        } catch (InputMismatchException e) {
            System.out.println("The expression has more left parenthesis then right parenthesis");
        }
    }
}
