//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        // Base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;  // All deletions
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;  // All insertions
        }
        
        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, // Remove
                                 dp[i][j - 1] + 1), // Insert
                        dp[i - 1][j - 1] + 1 // Replace
                    );
                }
            }
        }
        
        return dp[n][m];
    }
}
