//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static int minRemoval(int intervals[][]) {
        // Sort intervals by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Count of non-overlapping intervals
        int prevEnd = Integer.MIN_VALUE;

        // Iterate through sorted intervals
        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                // If the interval does not overlap, include it
                count++;
                prevEnd = interval[1]; // Update the end time of the last included interval
            }
        }

        // Total intervals - Non-overlapping intervals = Intervals to be removed
        return intervals.length - count;
    }
}

