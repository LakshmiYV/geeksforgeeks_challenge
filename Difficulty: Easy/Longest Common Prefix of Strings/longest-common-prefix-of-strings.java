//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Compare characters of the first and last string in the sorted array
        String first = arr[0];
        String last = arr[arr.length - 1];
        
        int minLength = Math.min(first.length(), last.length());
        
        int i = 0;
        while (i < minLength && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        String commonPrefix = first.substring(0, i);
        
        return commonPrefix.isEmpty() ? "-1" : commonPrefix;
    }
}
