//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length; // number of rows
        int m = mat[0].length; // number of columns
        
        int i = 0; // starting row
        int j = m - 1; // starting column (top-right corner)
        
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true; // element found
            } else if (mat[i][j] > x) {
                j--; // move left
            } else {
                i++; // move down
            }
        }
        
        return false; // element not found
    }
}
