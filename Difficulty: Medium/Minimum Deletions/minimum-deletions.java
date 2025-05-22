class Solution {
    static int minDeletions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        
        // DP table for LCS
        int[][] dp = new int[n + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Minimum deletions = total length - longest palindromic subsequence
        return n - dp[n][n];
    }
}
