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
        int max_sum = arr[0]; // Initialize max_sum with the first element
        int current_sum = arr[0]; // Initialize current_sum with the first element

        // Start iterating from the second element
        for (int i = 1; i < arr.length; i++) {
            // Either add the current element to the subarray or start a new subarray
            current_sum = Math.max(arr[i], current_sum + arr[i]);

            // Update max_sum if current_sum is greater
            max_sum = Math.max(max_sum, current_sum);
        }

        return max_sum;
    }
}

