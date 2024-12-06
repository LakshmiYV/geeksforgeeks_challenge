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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Create a temporary array for mergesort
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }
    
    // Function to implement merge sort and count inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            // Find the midpoint
            int mid = (left + right) / 2;

            // Recursively divide and count inversions in left and right halves
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);

            // Merge the two halves and count cross inversions
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }
    
    // Function to merge two sorted halves and count cross inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;     // Starting index for the left subarray
        int j = mid + 1;  // Starting index for the right subarray
        int k = left;     // Starting index to write merged elements
        int count = 0;

        // Merge the two subarrays
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // Count inversions: all remaining elements in the left subarray are inversions
                count += (mid - i + 1);
            }
        }

        // Copy remaining elements of the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements of the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
