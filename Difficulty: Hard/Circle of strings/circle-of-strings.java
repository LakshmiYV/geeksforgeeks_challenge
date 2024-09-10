//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends



class Solution {
    // Helper function to check if all characters with edges are strongly connected
    private void dfs(int node, boolean[] visited, List<List<Integer>> adjList) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adjList);
            }
        }
    }
    
    // Function to check if the strings can be chained to form a circle
    public int isCircle(String arr[]) {
        // Edge case: if there is only one string, check if its first and last character are the same
        if (arr.length == 1) {
            return arr[0].charAt(0) == arr[0].charAt(arr[0].length() - 1) ? 1 : 0;
        }
        
        // Create adjacency list and track in-degree and out-degree for each character
        int[] inDegree = new int[26]; // in-degree count for characters 'a' to 'z'
        int[] outDegree = new int[26]; // out-degree count for characters 'a' to 'z'
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Build the graph and update in-degree/out-degree counts
        for (String str : arr) {
            int first = str.charAt(0) - 'a'; // First character of the string
            int last = str.charAt(str.length() - 1) - 'a'; // Last character of the string
            adjList.get(first).add(last); // Add an edge from first to last character
            outDegree[first]++;
            inDegree[last]++;
        }
        
        // Check if in-degree and out-degree of every character are equal
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0;
            }
        }
        
        // Check if all characters with edges are in the same strongly connected component
        boolean[] visited = new boolean[26];
        int startNode = -1; // Find a starting node (a character with at least one outgoing edge)
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startNode = i;
                break;
            }
        }
        
        // Perform DFS from the start node
        dfs(startNode, visited, adjList);
        
        // Check if all characters with non-zero out-degree are visited
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return 0;
            }
        }
        
        return 1; // The strings can form a circle
    }
}
