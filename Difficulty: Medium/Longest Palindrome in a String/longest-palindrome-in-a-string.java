//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Static method to find the longest palindromic substring
    static String longestPalindrome(String s) {

        // Initialize variables to keep track of the
        // longest palindrome and its length.
        int count = -1;
        String ans = "";

        // Get the length of the input string.
        int n = s.length();

        // Create a boolean 2D array to store palindrome information.
        boolean[][] dp = new boolean[n][n];

        // Iterate through different substring lengths.
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                // Check if the substring is of length 1 (base case).
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    // Check if the substring is of length 2 (base case).
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // Check if the current substring is a
                    // palindrome based on its ends.
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                // Update the longest palindrome and its length if found.
                if (dp[i][j] && count < s.substring(i, j + 1).length()) {
                    ans = s.substring(i, j + 1);
                    count = ans.length();
                }
            }
        }
        return ans;
    }
}
