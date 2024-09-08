//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        // Edge case: If the first element is 0 and the array length is greater than 1
        if (n == 1) return 0;
        if (arr[0] == 0) return -1;
        
        // Initialize variables
        int jumps = 1;       // At least one jump is needed
        int maxReach = arr[0]; // Max index we can currently reach
        int steps = arr[0];   // Steps we can still take before we must jump
        
        for (int i = 1; i < n; i++) {
            // Check if we have reached the last index
            if (i == n - 1) return jumps;
            
            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);
            
            // Use one step to move forward
            steps--;
            
            // If no more steps left, we must jump
            if (steps == 0) {
                jumps++;
                
                // If we can't reach further, return -1
                if (i >= maxReach) return -1;
                
                // Reinitialize steps to the amount we can jump from the new range
                steps = maxReach - i;
            }
        }
        
        // If we complete the loop and haven't returned, return -1
        return -1;
    }
}
