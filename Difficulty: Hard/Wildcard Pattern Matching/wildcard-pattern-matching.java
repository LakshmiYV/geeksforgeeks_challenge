//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    // Method to find if a given pattern matches a given string using wildcards.
    public int wildCard(String pattern, String str) {
        int l1 = str.length(), l2 = pattern.length();
        int dp[][] = new int[l1 + 1][l2 + 1];

        // Initializing the dp array.
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                // Setting dp[0][0] to 1 to indicate that empty pattern and empty string
                // match.
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                // If the string is empty and the pattern is not, setting dp[i][j] to 0.
                else if (i == 0) {
                    if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
                // If the pattern is empty and the string is not, setting dp[i][j] to 0.
                else if (j == 0) {
                    dp[i][j] = 0;
                }
                // If both string and pattern are not empty.
                else {
                    // If the current character in pattern is '*', checking previous
                    // rows in the dp array. If any of the previous rows have a 1 in the
                    // current column, setting current dp[i][j] to 1. Otherwise, setting
                    // it to 0.
                    if (pattern.charAt(j - 1) == '*') {
                        if (dp[i - 1][j] > 0 || dp[i][j - 1] > 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = 0;
                        }
                    }
                    // If the current character in pattern is '?' or matches the current
                    // character in string, setting dp[i][j] to dp[i - 1][j - 1].
                    else if (pattern.charAt(j - 1) == '?' ||
                             pattern.charAt(j - 1) == str.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // If none of the conditions are met, setting dp[i][j] to 0.
                    else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        // Returning the value in the bottom-right corner of the dp array.
        return dp[l1][l2];
    }
}