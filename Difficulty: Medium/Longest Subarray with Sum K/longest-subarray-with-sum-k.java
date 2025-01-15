//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store prefix sums and their earliest occurrence index
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0;  // Running sum of the elements
        int maxLength = 0;   // Maximum length of subarray with sum k

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // If the current sum equals k, update the maximum length
            if (currentSum == k) {
                maxLength = i + 1;
            }

            // If (currentSum - k) exists in the map, update the maximum length
            if (prefixSumMap.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentSum - k));
            }

            // Store the current sum in the map if it is not already present
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;  // Return the length of the longest subarray
    }
}
