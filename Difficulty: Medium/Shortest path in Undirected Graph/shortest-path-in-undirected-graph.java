//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends



class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        // Distance array to store the shortest path from src to each node
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // Initialize distances as -1 (unreachable)
        dist[src] = 0; // Distance to the source is 0

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int distance = dist[node];

            // Explore all neighbors
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // If not visited
                    dist[neighbor] = distance + 1;
                    queue.add(neighbor);
                }
            }
        }

        return dist;
    }
}
