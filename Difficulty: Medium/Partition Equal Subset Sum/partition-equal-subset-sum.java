//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int equalPartition(int N, int arr[]) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, return 0 (NO)
        if (totalSum % 2 != 0) {
            return 0;
        }
        
        // We need to find a subset with sum equal to totalSum / 2
        int target = totalSum / 2;
        
        // Initialize a DP array where dp[j] means whether a sum of j can be achieved
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // We can always achieve a sum of 0
        
        // Update the DP array based on the elements in the array
        for (int i = 0; i < N; i++) {
            for (int j = target; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }
        
        // The result is whether we can achieve the target sum
        return dp[target] ? 1 : 0;
    }
}

