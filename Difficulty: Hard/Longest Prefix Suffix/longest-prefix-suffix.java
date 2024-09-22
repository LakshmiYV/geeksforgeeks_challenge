//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


class Solution {
    int lps(String str) {
        int n = str.length();
        int[] lps = new int[n];
        
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        
        // the loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else { // (str[i] != str[len])
                if (len != 0) {
                    len = lps[len - 1];
                } else { // if (len == 0)
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // the longest proper prefix which is also suffix
        return lps[n - 1];
    }
}
