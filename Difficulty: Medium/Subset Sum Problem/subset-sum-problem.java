//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // Create a DP table to store results of subproblems
        boolean dp[][] = new boolean[N + 1][sum + 1];
        
        // Initialize the DP table
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true; // A sum of 0 can always be made with an empty subset
        }
        
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; // With 0 elements, no positive sum can be achieved
        }
        
        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                // Exclude the element
                dp[i][j] = dp[i-1][j];
                
                // Include the element (if it doesn't exceed the sum)
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }
        
        // The answer will be in dp[N][sum]
        return dp[N][sum];
    }
}
