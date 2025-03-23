//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countWays(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1]; // dp[i] represents ways to decode first i digits
        dp[0] = 1; // Base case: Empty string has 1 way to decode
        dp[1] = 1; // Single valid digit has 1 way to decode

        for (int i = 2; i <= n; i++) {
            int oneDigit = digits.charAt(i - 1) - '0'; // Last single digit
            int twoDigit = Integer.parseInt(digits.substring(i - 2, i)); // Last two digits

            // If the last single digit is valid (1-9), add dp[i-1]
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // If the last two digits form a valid number (10-26), add dp[i-2]
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
