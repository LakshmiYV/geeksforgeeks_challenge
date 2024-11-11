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
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Sort the array to handle duplicates in order
        Arrays.sort(arr);
        int increments = 0;

        // Iterate over the sorted array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // If the current element is not greater than the previous element
            if (arr[i] <= arr[i - 1]) {
                // Calculate the increment needed to make arr[i] unique
                int requiredIncrement = arr[i - 1] + 1 - arr[i];
                arr[i] += requiredIncrement;
                increments += requiredIncrement;
            }
        }
        return increments;
    }
}
