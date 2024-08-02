//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


class Solution {
    public boolean isInterLeave(String A, String B, String C) {
        int n = A.length();
        int m = B.length();
        int l = C.length();

        // If the length of C is not equal to the sum of lengths of A and B, return false
        if (n + m != l) {
            return false;
        }

        // Create a 2D DP array
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Initialize the DP array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // If both A and B are empty
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // If A is empty, we check if B[0..j-1] matches C[0..j-1]
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1);
                }
                // If B is empty, we check if A[0..i-1] matches C[0..i-1]
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1);
                }
                // For other cases, we check both possibilities
                else {
                    dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) || 
                               (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
                }
            }
        }

        // The result is stored in dp[n][m]
        return dp[n][m];
    }
}


