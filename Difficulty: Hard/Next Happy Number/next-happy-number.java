//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


class Solution{

    // Helper function to check if a number is happy
    static boolean isHappy(int num) {
        HashSet<Integer> seen = new HashSet<>();
        
        // Continue the process until the number becomes 1 or enters a cycle
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = getSumOfSquares(num);
        }
        
        return num == 1;
    }

    // Function to get the sum of the squares of the digits of a number
    static int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // Main function to find the next happy number
    static int nextHappy(int N){
        N++; // Start checking from the next number after N
        
        // Keep incrementing N until a happy number is found
        while (!isHappy(N)) {
            N++;
        }
        
        return N; // Return the next happy number
    }
}
