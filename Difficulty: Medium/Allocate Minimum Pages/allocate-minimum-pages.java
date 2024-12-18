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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public static int findPages(int[] arr, int k) {
        // Edge case: If students are more than books, allocation is not possible
        if (k > arr.length) {
            return -1;
        }

        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages); // Minimum possible max pages
            high += pages;             // Sum of all pages
        }

        int result = -1;

        // Binary search to find the minimum maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(arr, k, mid)) {
                result = mid; // Valid allocation, try for a smaller maximum
                high = mid - 1;
            } else {
                low = mid + 1; // Invalid allocation, increase the maximum
            }
        }

        return result;
    }

    private static boolean isFeasible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1; // Start with one student
        int pagesSum = 0;

        for (int pages : arr) {
            if (pagesSum + pages > maxPages) {
                // Allocate to a new student
                studentsRequired++;
                pagesSum = pages;

                // If more students are required than available, return false
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                pagesSum += pages;
            }
        }

        return true;
    }
}
