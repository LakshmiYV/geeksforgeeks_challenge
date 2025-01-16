//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Map to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Replace 0 with -1 for easier computation
            prefixSum += (arr[i] == 0) ? -1 : 1;

            // If prefix sum is 0, we found a subarray from the start
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // Check if this prefix sum has been seen before
            if (prefixSumMap.containsKey(prefixSum)) {
                // Calculate the length of the subarray
                int prevIndex = prefixSumMap.get(prefixSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this prefix sum
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}

