//{ Driver Code Starts
// Initial Template for Java.
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends

//Back-end complete function Template for Java
class Solution {
    public int maximumProfit(int prices[]) {
        int ans = 0;
        int n = prices.length;
        if (n == 0) return 0; // Handle the case if the list is empty

        int st = prices[0],
            end = prices[0]; // Use get() to access elements in the List
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                end = prices[i]; // Update end when prices increase
            } else {
                ans += end - st; // Accumulate the profit
                st = prices[i];  // Start a new buy at the current price
                end = st;        // Reset end to st
            }
        }
        ans += end - st; // Add the last transaction profit
        return ans;
    }
}