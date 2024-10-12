//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) a[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            int res = obj.pairWithMaxSum(a);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public int pairWithMaxSum(int[] arr) {
        int n = arr.length;

        // If the array size is less than 2, return -1
        if (n < 2) {
            return -1;
        }

        // Initialize maxSum to the minimum possible value
        int maxSum = Integer.MIN_VALUE;

        // Iterate through the array, checking adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            // Calculate the sum of the current pair
            int sum = arr[i] + arr[i + 1];

            // Update maxSum if this sum is greater
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

