//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        long S0 = 0;
        long arrSum = 0;
        
        // Calculate initial sum S0 and the total array sum
        for (int i = 0; i < n; i++) {
            S0 += (long)i * a[i];
            arrSum += a[i];
        }
        
        long maxSum = S0;
        long currentSum = S0;
        
        // Calculate the sums for subsequent rotations
        for (int i = 1; i < n; i++) {
            currentSum = currentSum + arrSum - (long)n * a[n - i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

