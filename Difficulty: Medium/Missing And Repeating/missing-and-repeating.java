//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        // Traverse the array and mark visited elements
        for (int i = 0; i < n; i++) {
            int value = Math.abs(arr[i]);
            
            // If the value is already negative, it means it's repeated
            if (arr[value - 1] < 0) {
                repeating = value;
            } else {
                // Mark the index corresponding to the value as negative
                arr[value - 1] = -arr[value - 1];
            }
        }

        // Find the missing number (positive index)
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{repeating, missing};
    }
}
