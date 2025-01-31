//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// Optimized Sudoku Solver using HashSets and Forward Checking
class Solution {
    static void solveSudoku(int[][] mat) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][] boxUsed = new boolean[9][10];

        // Pre-fill the sets with existing numbers in the Sudoku grid
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != 0) {
                    int num = mat[i][j];
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[boxIndex(i, j)][num] = true;
                }
            }
        }
        solve(mat, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private static boolean solve(int[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] boxUsed, int row, int col) {
        if (row == 9) return true; // Solved
        if (col == 9) return solve(board, rowUsed, colUsed, boxUsed, row + 1, 0); // Move to next row

        if (board[row][col] != 0) return solve(board, rowUsed, colUsed, boxUsed, row, col + 1); // Skip pre-filled cells

        // Try placing numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            int boxIdx = boxIndex(row, col);
            if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[boxIdx][num]) {
                // Place the number
                board[row][col] = num;
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIdx][num] = true;

                if (solve(board, rowUsed, colUsed, boxUsed, row, col + 1)) return true; // Recursive call

                // Backtrack
                board[row][col] = 0;
                rowUsed[row][num] = colUsed[col][num] = boxUsed[boxIdx][num] = false;
            }
        }
        return false; // No valid number found
    }

    private static int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
