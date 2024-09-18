//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        // Stack to keep track of opening brackets.
        Stack<Character> stack = new Stack<>();
        
        // Traverse through the string.
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            
            // If it's an opening bracket, push it onto the stack.
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for balance.
            else {
                // If stack is empty, no opening bracket to match with, return false.
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Pop the top of the stack and check if it matches the current closing bracket.
                char top = stack.pop();
                if ((ch == '}' && top != '{') || (ch == ']' && top != '[') || (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        
        // If the stack is empty after processing the entire string, it's balanced.
        return stack.isEmpty();
    }
}

