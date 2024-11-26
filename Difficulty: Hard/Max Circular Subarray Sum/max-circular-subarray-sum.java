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
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Case 1: Non-circular subarray sum using Kadane's algorithm
        int max_kadane = kadane(arr);

        // Calculate the total sum of the array
        int total_sum = 0;
        for (int i = 0; i < n; i++) {
            total_sum += arr[i];
        }

        // Case 2: Circular subarray sum
        // Invert the elements of the array to find the minimum subarray sum
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }
        int min_kadane = kadane(arr);

        // Restore the array
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i];
        }

        // Maximum circular sum
        int max_circular = total_sum + min_kadane; // Adding because min_kadane was computed on the inverted array

        // If all numbers are negative, max_circular will be 0. We need to handle this case.
        if (max_circular == 0) {
            return max_kadane;
        }

        return Math.max(max_kadane, max_circular);
    }

    // Helper function to find the maximum subarray sum using Kadane's algorithm
    private int kadane(int[] arr) {
        int max_ending_here = arr[0];
        int max_so_far = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
