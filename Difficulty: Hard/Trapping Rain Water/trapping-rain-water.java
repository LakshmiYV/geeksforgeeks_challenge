//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Optimized space approach using two pointers
    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n <= 2) return 0; // No water can be trapped with less than 3 blocks
        
        int left = 0, right = n - 1;  // Two pointers
        int leftMax = 0, rightMax = 0; // To keep track of max heights
        int totalWater = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left]; // Update left max
                } else {
                    totalWater += leftMax - arr[left]; // Water trapped at left
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; // Update right max
                } else {
                    totalWater += rightMax - arr[right]; // Water trapped at right
                }
                right--;
            }
        }

        return totalWater;
    }
}

