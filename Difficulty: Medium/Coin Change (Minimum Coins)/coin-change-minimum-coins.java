//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int M, int sum) {
        // Initialize the dp array with a large value
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: no coins needed to make sum 0
        dp[0] = 0;
        
        // Build the dp array
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < M; j++) {
                if (coins[j] <= i) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        
        // If dp[sum] is still Integer.MAX_VALUE, it means the sum can't be achieved with the given coins
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
