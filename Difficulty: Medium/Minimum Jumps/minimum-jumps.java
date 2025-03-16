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
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        if (arr.length <= 1) return 0;  // Already at the end
        if (arr[0] == 0) return -1;     // Cannot move

        int jumps = 1;                  // Initial jump
        int currentEnd = arr[0];        // Max index reachable in the current jump
        int farthest = arr[0];          // Max index reachable overall

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps; // Reached the last index

            farthest = Math.max(farthest, i + arr[i]); // Update the farthest reach

            if (i == currentEnd) { // Need to take another jump
                jumps++;
                currentEnd = farthest;

                if (currentEnd <= i) return -1; // Stuck at this index
            }
        }
        return -1; // Should never reach here
    }
}
