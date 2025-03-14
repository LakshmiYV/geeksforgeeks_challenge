//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];

        // Initialize dp array with a large value
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0; // Base case: 0 coins needed to make sum 0

        // Bottom-up DP approach
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE - 1) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
                }
            }
        }

        // If the sum cannot be formed, return -1
        return (dp[sum] == Integer.MAX_VALUE - 1) ? -1 : dp[sum];
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends