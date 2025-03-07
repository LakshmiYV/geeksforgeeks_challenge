//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestPalinSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table in bottom-up manner
        for (int len = 2; len <= n; len++) {  // len is the length of substring
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;  // Endpoint of the substring
                
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];  // Extend palindrome
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);  // Take max
                }
            }
        }

        return dp[0][n - 1]; // Full string result
    }
}
