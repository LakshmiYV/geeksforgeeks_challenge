//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; // Only one tower, no difference
        
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Initial difference between the highest and lowest
        int result = arr[n - 1] - arr[0];
        
        // Step 2: Initialize smallest and largest heights after modification
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        // Swap smallest and largest if necessary
        if (smallest > largest) {
            int temp = smallest;
            smallest = largest;
            largest = temp;
        }
        
        // Step 3: Traverse the array and try modifying heights
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            result = Math.min(result, maxHeight - minHeight);
        }
        
        return result;
    }
}
