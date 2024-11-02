//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // Create a HashSet to store elements within the last k indices
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Check if the element is already in the set
            if (set.contains(arr[i])) {
                return true; // Duplicate found within k distance
            }
            
            // Add the current element to the set
            set.add(arr[i]);
            
            // Ensure the set only contains elements within the last k indices
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }
        
        return false; // No duplicates found within k distance
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
            Solution obj = new Solution();
            boolean res = obj.checkDuplicatesWithinK(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends