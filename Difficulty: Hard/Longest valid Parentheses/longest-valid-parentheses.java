//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int maxLength(String S){
        // Stack to store indices of parentheses
        Stack<Integer> stack = new Stack<>();
        // Push -1 to the stack to handle base case for valid substrings
        stack.push(-1);
        int maxLength = 0;
        
        // Traverse the string
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                // Push the index of '(' to the stack
                stack.push(i);
            } else {
                // Pop the top index
                stack.pop();
                
                // If stack is empty, push the current index as a base for valid substrings
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the valid substring
                    int length = i - stack.peek();
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }
}
