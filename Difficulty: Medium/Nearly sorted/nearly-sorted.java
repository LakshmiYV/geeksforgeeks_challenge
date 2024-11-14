//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java


class Solution {
    public void nearlySorted(int[] arr, int k) {
        // Min-heap to keep track of the next smallest elements within the range of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Insert the first k+1 elements in the min-heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int index = 0; // index to place the sorted element in the array
        
        // Process the remaining elements in the array
        for (int i = k + 1; i < arr.length; i++) {
            // Place the minimum element from the heap to the current sorted position
            arr[index++] = minHeap.poll();
            // Add the current element to the heap
            minHeap.add(arr[i]);
        }

        // Place remaining elements from the heap into the array
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}



//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
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
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call nearlySorted on the instance
            obj.nearlySorted(arr, k);

            // Print the sorted array
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            // System.out.println("~");
        }
    }
}

// } Driver Code Ends