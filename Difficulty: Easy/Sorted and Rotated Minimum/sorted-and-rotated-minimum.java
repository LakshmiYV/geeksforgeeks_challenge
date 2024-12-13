//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        // Binary search logic
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid is greater than the high element
            if (arr[mid] > arr[high]) {
                // Minimum is in the right part
                low = mid + 1;
            } else {
                // Minimum is in the left part (including mid)
                high = mid;
            }
        }

        // Low will point to the smallest element
        return arr[low];
    }
}
