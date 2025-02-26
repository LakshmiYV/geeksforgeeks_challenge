//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends




class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n + 1];  // Stores maximum of minimums for each window size
        
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        
        Stack<Integer> stack = new Stack<>();
        
        // Find previous smaller element for each index
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        
        stack.clear();
        
        // Find next smaller element for each index
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // Compute the minimum elements for each window size
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            res[windowSize] = Math.max(res[windowSize], arr[i]);
        }
        
        // Fill the result array in reverse order
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(res[i]);
        }
        
        return result;
    }
}

