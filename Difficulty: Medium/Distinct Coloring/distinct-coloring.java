//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static long distinctColoring(int N, int[] r, int[] g, int[] b) {
        // DP arrays to store the minimum cost up to house i
        long[] dpRed = new long[N];
        long[] dpGreen = new long[N];
        long[] dpBlue = new long[N];
        
        // Initialize the first house's cost
        dpRed[0] = r[0];
        dpGreen[0] = g[0];
        dpBlue[0] = b[0];
        
        // Fill the dp arrays for each house from 1 to N-1
        for (int i = 1; i < N; i++) {
            dpRed[i] = r[i] + Math.min(dpGreen[i-1], dpBlue[i-1]);
            dpGreen[i] = g[i] + Math.min(dpRed[i-1], dpBlue[i-1]);
            dpBlue[i] = b[i] + Math.min(dpRed[i-1], dpGreen[i-1]);
        }
        
        // The answer is the minimum cost of painting the last house with any color
        return Math.min(dpRed[N-1], Math.min(dpGreen[N-1], dpBlue[N-1]));
    }
}



//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input[] = read.readLine().trim().split("\\s+");
            int[]r=new int[N];
            for(int i=0;i<N;i++)
                r[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]g=new int[N];
            for(int i=0;i<N;i++)
                g[i]=Integer.parseInt(input[i]);
            input = read.readLine().trim().split("\\s+");
            int[]b=new int[N];
            for(int i=0;i<N;i++)
                b[i]=Integer.parseInt(input[i]);

            Solution ob = new Solution();
            out.println(ob.distinctColoring(N, r, g, b));
        }
        out.close();
    }
}
// } Driver Code Ends