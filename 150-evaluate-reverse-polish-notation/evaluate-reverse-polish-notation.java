import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Check if token is an operator
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b); // integer division truncates toward zero
            } else {
                // Operand → convert to integer and push
                stack.push(Integer.parseInt(token));
            }
        }

        // Final result will be the only element in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens1)); // Output: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens2)); // Output: 6

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens3)); // Output: 22
    }
}
