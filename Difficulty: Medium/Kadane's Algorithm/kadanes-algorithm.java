//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
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

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        int max_so_far = Integer.MIN_VALUE; // To store the maximum sum of subarray
        int max_ending_here = 0;           // To store the current sum of subarray

        for (int num : arr) {
            max_ending_here += num;

            // Update max_so_far if max_ending_here is greater
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }

            // Reset max_ending_here to 0 if it becomes negative
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        return max_so_far;
    }
}

