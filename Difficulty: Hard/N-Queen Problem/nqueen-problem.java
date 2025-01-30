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
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n]; // Stores the row positions of queens
        solveNQueen(0, n, board, result);
        return result;
    }

    private void solveNQueen(int col, int n, int[] board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            // Found a valid placement, add to result
            ArrayList<Integer> solution = new ArrayList<>();
            for (int row : board) {
                solution.add(row + 1); // Convert 0-based index to 1-based
            }
            result.add(solution);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;
                solveNQueen(col + 1, n, board, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            // Check same row and diagonals
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
