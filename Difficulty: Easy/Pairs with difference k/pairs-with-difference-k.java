//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.countPairsWithDiffK(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        int n = arr.length;
        int maxEle = 0;
        // Find the maximum element in the array.
        for (int i = 0; i < n; i++) {
            maxEle = Math.max(maxEle, arr[i]);
        }
        // Create a hash table to store the occurrences of each element.
        int[] hash = new int[maxEle + 1];
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        // Initialize the count of pairs with difference k to 0.
        int count = 0;
        for (int i = 0; i <= maxEle; i++) {
            // Check if the element exists in the array.
            if (hash[i] > 0) {
                // If the difference is 0, calculate the number of pairs with difference
                // 0.
                if (k == 0) {
                    count += (hash[i] * (hash[i] - 1)) / 2;
                } else if (i + k <= maxEle) {
                    // Calculate the number of pairs with difference k.
                    count += (hash[i] * hash[i + k]);
                }
            }
        }
        // Return the count of pairs with difference k.
        return count;
    }
}
