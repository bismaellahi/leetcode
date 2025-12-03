import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    // Initialize the stack object
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int val) {
        stack.push(val);
        // Push onto minStack if it's empty or val <= current min
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Remove element on top of stack
    public void pop() {
        int removed = stack.pop();
        // If removed element is the current min, pop from minStack too
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get top element
    public int top() {
        return stack.peek();
    }

    // Retrieve minimum element
    public int getMin() {
        return minStack.peek();
    }

    // For testing
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}
