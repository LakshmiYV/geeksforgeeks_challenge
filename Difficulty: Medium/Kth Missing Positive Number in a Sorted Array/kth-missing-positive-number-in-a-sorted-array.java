//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        int missingCount = 0; // Count of missing numbers
        int currentNumber = 1; // Start from the smallest positive number
        int index = 0; // Array index

        // Loop until we find the kth missing number
        while (missingCount < k) {
            if (index < arr.length && arr[index] == currentNumber) {
                // If the current number is in the array, move to the next array element
                index++;
            } else {
                // Otherwise, it's a missing number
                missingCount++;
                if (missingCount == k) {
                    return currentNumber;
                }
            }
            currentNumber++;
        }

        return -1; // This should not be reached
    }
}
