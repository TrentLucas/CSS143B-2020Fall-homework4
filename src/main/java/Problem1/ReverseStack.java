package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        // homework
        if (stack.size() > 0) {
            int temp = stack.pop();
            reverseStack(stack);
            insert(stack, temp);
        }
    }
    public static void insert(Stack<Integer> stack, int value) {
        if (stack.size() == 0) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insert(stack, value);
        stack.push(temp);
    }
}