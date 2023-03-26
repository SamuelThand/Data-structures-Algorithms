package Q2;

import util.THStack;

/**
 *
 */
public class ParenthesisBalanceChecker {
    THStack<Character> stack;

    public ParenthesisBalanceChecker() {
        this.stack = new THStack<>();
    }

    public int isBalanced(String input) {
        int maximumDepth = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                maximumDepth = stack.size() > maximumDepth ? stack.size() : maximumDepth;
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? maximumDepth : -1;
    }



}
