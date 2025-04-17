//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    // Construct adjacency list
    public static ArrayList<ArrayList<int[]>> constructAdj(int V, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }

        return adj;
    }

    // shortest path from src to dest
    public static int shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src,
                                   int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src] = 0;
        pq.offer(new int[] {0, src});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];

                // direct edge being removed to check for a cycle
                if ((u == src && v == dest) || (u == dest && v == src)) continue;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[v], v});
                }
            }
        }

        return dist[dest];
    }

    public int findMinCycle(int V, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = constructAdj(V, edges);
        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int dist = shortestPath(V, adj, u, v);
            if (dist != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist + w);
            }
        }

        return minCycle;
    }
};