//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int MinSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Initialize dp array with a large number
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case
        dp[0] = 0;
        
        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        // The answer will be in dp[n]
        return dp[n];
    }
}
