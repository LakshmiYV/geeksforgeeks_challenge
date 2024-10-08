//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int i = 1;
        int n = arr.size();
        while (i < (n / 2) + 1) {
            Collections.rotate(arr, 1); // Rotate the array to the right by 1
            arr.remove(arr.size() - i); // Remove the element at position (size - i)
            i++;
        }
        return arr.get(0);
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
            ArrayList<Integer> arr = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr.add(Integer.parseInt(token));
            }

            Solution obj = new Solution();
            int res = obj.rotateDelete(arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends