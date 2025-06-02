class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // If start or end is blocked, return 0
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return 0;

        int[][] dp = new int[n][m];

        // Initialize starting point
        dp[0][0] = 1;

        // Fill DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Skip blocked cells and the start cell
                if (grid[i][j] == 1 || (i == 0 && j == 0)) continue;

                // Add ways from top cell if valid
                if (i > 0) dp[i][j] += dp[i - 1][j];
                // Add ways from left cell if valid
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }
}
