//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    boolean twoSum(int arr[], int target) {
        // Create a HashSet to store elements we've seen
        HashSet<Integer> seen = new HashSet<>();
        
        // Iterate through the array
        for (int num : arr) {
            // Calculate the complement
            int complement = target - num;
            
            // Check if the complement is already in the set
            if (seen.contains(complement)) {
                return true;
            }
            
            // Add the current number to the set
            seen.add(num);
        }
        
        // If no pair is found
        return false;
    }
}
