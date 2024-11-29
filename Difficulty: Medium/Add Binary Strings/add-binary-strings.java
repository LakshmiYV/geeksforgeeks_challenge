//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1; // Pointer for s1
        int j = s2.length() - 1; // Pointer for s2
        int carry = 0; // Initialize carry
        
        // Process both strings from the end
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0; // Get bit from s1 or 0 if out of bounds
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0; // Get bit from s2 or 0 if out of bounds
            
            int sum = bit1 + bit2 + carry; // Sum the bits and carry
            result.append(sum % 2); // Append the result (0 or 1)
            carry = sum / 2; // Calculate the carry
            
            i--; // Move to the next bit in s1
            j--; // Move to the next bit in s2
        }
        
        // Reverse the result to get the correct binary number
        result.reverse();
        
        // Remove leading zeros if present
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}
