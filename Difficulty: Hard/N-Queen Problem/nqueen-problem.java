//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];  // This array will hold the row positions for each column
        solveNQueens(result, board, 0, n);
        return result;
    }
    
    private void solveNQueens(ArrayList<ArrayList<Integer>> result, int[] board, int col, int n) {
        if (col == n) {  // All queens are placed
            addSolution(result, board, n);
            return;
        }
        
        for (int i = 0; i < n; i++) {  // Try placing this queen in all rows
            if (isSafe(board, col, i)) {
                board[col] = i + 1;  // Place queen at (i, col) (1-indexed)
                solveNQueens(result, board, col + 1, n);
            }
        }
    }
    
    private boolean isSafe(int[] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row + 1 ||  // Check row
                Math.abs(board[i] - (row + 1)) == Math.abs(i - col)) {  // Check diagonal
                return false;
            }
        }
        return true;
    }
    
    private void addSolution(ArrayList<ArrayList<Integer>> result, int[] board, int n) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(board[i]);
        }
        result.add(solution);
    }
}
