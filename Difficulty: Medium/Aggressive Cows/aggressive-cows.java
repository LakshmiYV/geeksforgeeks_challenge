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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls array
        Arrays.sort(stalls);
        
        // Step 2: Initialize binary search range
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0; // To store the largest minimum distance
        
        // Step 3: Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid distance
            
            // Step 4: Check feasibility for the current mid distance
            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }
        
        return result;
    }
    
    // Helper function to check if it's possible to place cows with at least `dist` distance
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Last position of a placed cow
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++; // Place a cow here
                lastPosition = stalls[i]; // Update the last position
                
                if (count == k) {
                    return true; // All cows placed successfully
                }
            }
        }
        
        return false; // Not possible to place all cows
    }
}
