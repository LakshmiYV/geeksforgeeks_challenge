//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    // This function calculates the maximum possible profit from a given array of stock
    // prices
    public int maximumProfit(int prices[]) {
        // Initialize the minimum buy price as the first price in the array
        int buyPrice = prices[0];

        // Initialize the maximum profit as 0
        int maxProfit = 0;

        // Iterate through the array of prices starting from the second price (index 1)
        for (int i = 1; i < prices.length; i++) {
            // Update the maximum profit if the current profit (prices[i] - buyPrice) is
            // greater
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);

            // Update the minimum buy price if the current price is lower
            buyPrice = Math.min(buyPrice, prices[i]);
        }

        // Return the maximum possible profit
        return maxProfit;
    }
}