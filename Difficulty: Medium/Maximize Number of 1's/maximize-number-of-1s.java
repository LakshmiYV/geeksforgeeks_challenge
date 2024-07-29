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
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solve {
    // m is maximum number of zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        // Traverse the array with the right pointer
        for (int right = 0; right < n; right++) {
            // If current element is 0, increment zeroCount
            if (arr[right] == 0) {
                zeroCount++;
            }

            // While zeroCount exceeds m, move the left pointer to reduce zeros
            while (zeroCount > m) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the current window size and update maxLen
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
