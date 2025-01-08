//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr); // Step 1: Sort the array
        int count = 0;

        // Step 2: Iterate from the largest element to the third element
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;

            // Step 3: Use two-pointer technique
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // If arr[left] + arr[right] > arr[i], all elements
                    // between left and right pointers form valid triangles.
                    count += (right - left);
                    right--; // Move the right pointer leftward
                } else {
                    left++; // Otherwise, move the left pointer rightward
                }
            }
        }

        return count;
    }
}
