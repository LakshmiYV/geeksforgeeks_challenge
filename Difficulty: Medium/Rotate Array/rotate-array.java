//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int d = Integer.parseInt(in.readLine().trim()); // rotation count (key)
            int n = array.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = array.get(i);

            new Solution().rotateArr(arr, d); // rotating the array
            StringBuilder sb = new StringBuilder();

            // printing the elements of the array
            for (int value : arr) sb.append(value).append(" ");
            out.println(sb.toString().trim());

            out.println("~");
        }
        out.flush();
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

//Back-end complete function Template for Java

class Solution {
    // Function to reverse any part of the array.
    static void rvereseArray(int arr[], int start, int end) {
        int temp;

        while (start < end) {
            // Swapping values at start index and end index.
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Updating the values of start and end.
            start++;
            end--;
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d %= n;
        // First reversing d elements from starting index.
        rvereseArray(arr, 0, d - 1);
        // Then reversing the last n-d elements.
        rvereseArray(arr, d, n - 1);
        // Finally, reversing the whole array.
        rvereseArray(arr, 0, n - 1);
    }
}