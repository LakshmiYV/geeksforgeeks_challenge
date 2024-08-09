//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            // int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().Maximize(arr));
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {

    int Maximize(int arr[]) {
        // Modulo value as given in the problem
        int MOD = 1000000007;
        
        // Sort the array in non-decreasing order
        Arrays.sort(arr);
        
        // Initialize sum
        long sum = 0;
        
        // Calculate sum of arr[i] * i
        for (int i = 0; i < arr.length; i++) {
            sum = (sum + (long)arr[i] * i) % MOD;
        }
        
        // Return the result
        return (int) sum;
    }
}
