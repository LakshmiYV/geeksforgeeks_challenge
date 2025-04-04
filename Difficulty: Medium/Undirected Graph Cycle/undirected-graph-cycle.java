//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        int[] parent = new int[V];
        int[] rank = new int[V];

        // Initialize the parent of each node to itself
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = findParent(u, parent);
            int parentV = findParent(v, parent);

            if (parentU == parentV) {
                return true; // Cycle detected
            }

            union(parentU, parentV, parent, rank);
        }

        return false; // No cycle found
    }

    private int findParent(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = findParent(parent[node], parent); // Path compression
        }
        return parent[node];
    }

    private void union(int u, int v, int[] parent, int[] rank) {
        if (rank[u] > rank[v]) {
            parent[v] = u;
        } else if (rank[u] < rank[v]) {
            parent[u] = v;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }
}
