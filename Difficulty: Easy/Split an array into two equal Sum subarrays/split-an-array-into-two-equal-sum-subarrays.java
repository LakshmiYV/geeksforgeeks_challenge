//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, we can't split the array into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int leftSum = 0;
        int target = totalSum / 2;
        
        // Iterate through the array and check if we can find the target sum
        for (int num : arr) {
            leftSum += num;
            
            // If leftSum equals the target, we can split the array
            if (leftSum == target) {
                return true;
            }
        }
        
        // If we complete the loop without finding the target, return false
        return false;
    }
}
