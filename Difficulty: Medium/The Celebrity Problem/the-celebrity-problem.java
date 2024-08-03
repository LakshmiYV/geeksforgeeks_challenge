//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int left = 0;
        int right = n - 1;

        // Find the potential celebrity
        while (left < right) {
            if (mat[left][right] == 1) {
                // left knows right, so left cannot be a celebrity
                left++;
            } else {
                // right cannot be a celebrity
                right--;
            }
        }

        int potentialCelebrity = left;

        // Verify the potential celebrity
        for (int i = 0; i < n; i++) {
            // The potential celebrity should not know anyone
            if (i != potentialCelebrity && (mat[potentialCelebrity][i] == 1 || mat[i][potentialCelebrity] == 0)) {
                return -1;
            }
        }

        return potentialCelebrity;
    }
}
