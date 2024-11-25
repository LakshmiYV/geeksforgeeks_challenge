//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        
        // Initialize max and min products and global max
        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];
        
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                // Swap maxProd and minProd when a negative number is encountered
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            // Update maxProd and minProd
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            
            // Update result
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
}
