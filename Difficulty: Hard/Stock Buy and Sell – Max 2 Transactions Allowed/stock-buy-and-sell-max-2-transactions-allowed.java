//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        // Left profit - Max profit by one transaction from start to index i
        int[] leftProfit = new int[n];
        int minPrice = prices[0];
        
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }
        
        // Right profit - Max profit by one transaction from index i to end
        int[] rightProfit = new int[n];
        int maxPrice = prices[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }
        
        // Combine the two profits
        int maxProfit = rightProfit[0]; // In case we only make 1 transaction
        for (int i = 0; i < n - 1; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i + 1]);
        }
        
        return maxProfit;
    }
}

