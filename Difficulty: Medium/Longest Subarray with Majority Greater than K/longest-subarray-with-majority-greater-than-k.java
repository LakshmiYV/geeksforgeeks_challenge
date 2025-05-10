//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] trans = new int[n];

        // Transform the array to +1 and -1
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) trans[i] = 1;
            else trans[i] = -1;
        }

        Map<Integer, Integer> prefixMap = new HashMap<>();
        int maxLen = 0, prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += trans[i];

            if (prefixSum > 0) {
                // Entire array from 0 to i is valid
                maxLen = i + 1;
            } else {
                // Check if prefixSum - 1 was seen before
                if (prefixMap.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - prefixMap.get(prefixSum - 1));
                }
            }

            // Store first occurrence of each prefix sum
            prefixMap.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends