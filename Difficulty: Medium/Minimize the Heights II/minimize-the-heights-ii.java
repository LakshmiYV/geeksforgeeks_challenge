//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution {
    int getMinDiff(int[] arr, int k) {
        // Sort the array to get a structured view of the elements
        Arrays.sort(arr);
        int n = arr.length;

        // Initialize the answer as the difference between the largest and smallest elements
        int ans = arr[n - 1] - arr[0];

        // Minimum and maximum variables
        int min, max;

        // Traverse the sorted array, ignoring the first element
        for (int i = 1; i < n; i++) {
            // Check that we don't end up with negative values after subtracting K
            if (arr[i] - k < 0) continue;

            // Calculate the minimum value after modification
            min = Math.min(arr[0] + k, arr[i] - k);

            // Calculate the maximum value after modification
            max = Math.max(arr[n - 1] - k, arr[i - 1] + k);

            // Update the answer to the minimum difference
            ans = Math.min(ans, max - min);
        }

        return ans;
    }
}
