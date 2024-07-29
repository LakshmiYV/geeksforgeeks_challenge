//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] result = new int[2];
        
        // Calculate expected sum and sum of squares
        long sumN = (long)n * (n + 1) / 2;
        long sumSqN = (long)n * (n + 1) * (2 * n + 1) / 6;
        
        // Calculate actual sum and sum of squares
        long sumActual = 0, sumSqActual = 0;
        for (int i = 0; i < n; i++) {
            sumActual += arr[i];
            sumSqActual += (long)arr[i] * arr[i];
        }
        
        // Calculate differences
        long diffSum = sumN - sumActual; // X - Y
        long diffSumSq = sumSqN - sumSqActual; // X^2 - Y^2
        
        // Calculate X + Y
        long sumXPlusY = diffSumSq / diffSum;
        
        // Calculate X and Y
        int X = (int)((diffSum + sumXPlusY) / 2);
        int Y = (int)(sumXPlusY - X);
        
        result[0] = Y; // Repeating
        result[1] = X; // Missing
        
        return result;
    }
}
