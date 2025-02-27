//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop top element from stack
    public void pop() {
        if (!stack.isEmpty()) {
            int removed = stack.pop();
            if (!minStack.isEmpty() && removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    // Get top element of stack
    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    // Get minimum element of stack
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
