package Q2;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with nested parenthesis:");
        String input = scanner.nextLine();
        scanner.close();
        ParenthesisBalanceChecker balancer = new ParenthesisBalanceChecker();
        int result = balancer.isBalanced(input);
        if (result == -1) {
            System.out.println("Parenthesis not balanced");
        } else {
            System.out.println("Parenthesis balanced, maximum depth: " + result);
        }
    }
}
