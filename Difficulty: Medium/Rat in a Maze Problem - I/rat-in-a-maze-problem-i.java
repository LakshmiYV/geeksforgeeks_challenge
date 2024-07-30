//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length; // Determine the size of the matrix
        ArrayList<String> res = new ArrayList<>();
        if (mat[0][0] == 0) return res; // If start point is blocked, no paths available
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, mat, n, "", res, visited);
        return res;
    }
    
    private void solve(int x, int y, int[][] mat, int n, String path, ArrayList<String> res, boolean[][] visited) {
        // Base case: If we reach the bottom-right corner
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Move Down
        if (isSafe(x + 1, y, mat, n, visited)) {
            solve(x + 1, y, mat, n, path + 'D', res, visited);
        }
        // Move Left
        if (isSafe(x, y - 1, mat, n, visited)) {
            solve(x, y - 1, mat, n, path + 'L', res, visited);
        }
        // Move Right
        if (isSafe(x, y + 1, mat, n, visited)) {
            solve(x, y + 1, mat, n, path + 'R', res, visited);
        }
        // Move Up
        if (isSafe(x - 1, y, mat, n, visited)) {
            solve(x - 1, y, mat, n, path + 'U', res, visited);
        }

        // Backtrack: Unmark the current cell as visited
        visited[x][y] = false;
    }

    private boolean isSafe(int x, int y, int[][] mat, int n, boolean[][] visited) {
        return (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1 && !visited[x][y]);
    }
}


