//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m]; // To keep track of visited cells
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++; // New island found
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Base case: Check boundaries and whether the cell is water or already visited
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 'W' || visited[i][j]) {
            return;
        }

        visited[i][j] = true; // Mark the current cell as visited

        // All 8 possible directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int d = 0; d < 8; d++) {
            dfs(grid, visited, i + dx[d], j + dy[d]);
        }
    }
}
