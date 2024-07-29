//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length; // number of rows
        int m = arr[0].length; // number of columns
        
        int maxRowIndex = -1; // Initialize the result to -1 if no 1 is found
        int maxCount = 0; // Initialize the maximum count of 1s

        int j = m - 1; // Start from the top-right corner
        for (int i = 0; i < n; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j--; // Move left while there are 1s
                maxRowIndex = i; // Update the row index
                maxCount = m - j - 1; // Update the max count of 1s
            }
        }
        return maxRowIndex;
    }
}
