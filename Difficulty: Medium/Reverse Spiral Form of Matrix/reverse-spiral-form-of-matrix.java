//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



class Solution {
    public int[] reverseSpiral(int R, int C, int[][] a) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = R - 1;
        int left = 0, right = C - 1;

        while (top <= bottom && left <= right) {
            // Traverse from top left to top right
            for (int i = left; i <= right; i++) {
                result.add(a[top][i]);
            }
            top++;

            // Traverse from top right to bottom right
            for (int i = top; i <= bottom; i++) {
                result.add(a[i][right]);
            }
            right--;

            // Traverse from bottom right to bottom left if top <= bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(a[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom left to top left if left <= right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(a[i][left]);
                }
                left++;
            }
        }

        // Reverse the result to get the reverse spiral order
        Collections.reverse(result);
        
        // Convert List to array and return
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
