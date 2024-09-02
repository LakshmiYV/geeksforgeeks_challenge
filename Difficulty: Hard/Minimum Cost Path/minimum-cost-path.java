//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution {
    // Directions array to represent moving up, down, left, right
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    // Function to return the minimum cost to reach the bottom-right cell from the top-left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        
        // Priority Queue to store the cells with their associated cost.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Initialize distances with a large value
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start with the top-left cell
        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});
        
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];
            
            // If we reached the bottom-right cell, return the cost
            if (row == n - 1 && col == n - 1) {
                return cost;
            }
            
            // Explore the neighboring cells
            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                
                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    int newCost = cost + grid[newRow][newCol];
                    
                    // If a shorter path to the neighbor is found
                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.add(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }
        
        // If the bottom-right cell is not reachable, return -1 (shouldn't happen with given constraints)
        return -1;
    }
}
