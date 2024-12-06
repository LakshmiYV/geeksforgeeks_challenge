//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        int n = citations.length;

        // Counting array to store the frequency of citation counts
        int[] count = new int[n + 1];
        
        for (int c : citations) {
            if (c >= n) {
                count[n]++; // Count papers with citations >= n
            } else {
                count[c]++;
            }
        }

        // Traverse the count array in reverse to calculate H-index
        int total = 0; // Running total of papers with at least 'i' citations
        for (int i = n; i >= 0; i--) {
            total += count[i]; // Add papers with exactly 'i' citations
            if (total >= i) {
                return i; // Found the H-Index
            }
        }

        return 0; // In case no valid H-Index is found
    }
}
