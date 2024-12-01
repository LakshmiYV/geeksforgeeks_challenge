//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Create a hashmap to store frequency of each character
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        // Populate the frequency map
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Traverse the string to find the first non-repeating character
        for (char ch : s.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                return ch; // Return the first non-repeating character
            }
        }
        
        // If no non-repeating character found, return '$'
        return '$';
    }
}

