//{ Driver Code Starts
import java.util.*;

public class Main {
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
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int time;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        time = 0;

        // Handle disconnected graph
        for (int u = 0; u < V; u++) {
            if (!vis[u])
                dfs(u, adj, vis, disc, low, parent, ap);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) result.add(i);
        }

        return result.isEmpty() ? new ArrayList<>(Arrays.asList(-1)) : result;
    }

    static void dfs(int u, List<List<Integer>> adj, boolean[] vis,
                    int[] disc, int[] low, int[] parent, boolean[] ap) {
        vis[u] = true;
        disc[u] = low[u] = time++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!vis[v]) {
                children++;
                parent[v] = u;
                dfs(v, adj, vis, disc, low, parent, ap);
                low[u] = Math.min(low[u], low[v]);

                // Articulation point check
                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
