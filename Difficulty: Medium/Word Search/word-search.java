//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        // Create a visited array to keep track of the cells already used in the current DFS path.
        boolean[][] visited = new boolean[n][m];
        
        // Try to start the DFS from every cell in the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start DFS if the first character matches.
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // Helper method to perform DFS search.
    // i, j: current cell coordinates.
    // index: current index in the word that we need to match.
    // visited: tracks whether a cell has been visited in the current DFS path.
    static boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        // If we have matched all characters in the word, return true.
        if (index == word.length()) {
            return true;
        }
        
        // Check boundaries and whether the cell has already been visited or if the character doesn't match.
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited.
        visited[i][j] = true;
        
        // Directions arrays for moving up, down, left, and right.
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};
        
        // Explore all 4 directions.
        for (int k = 0; k < 4; k++) {
            int newRow = i + rowDir[k];
            int newCol = j + colDir[k];
            if (dfs(mat, word, newRow, newCol, index + 1, visited)) {
                return true;
            }
        }
        
        // Backtracking: unmark the cell as visited so it can be used in other DFS paths.
        visited[i][j] = false;
        return false;
    }
}
