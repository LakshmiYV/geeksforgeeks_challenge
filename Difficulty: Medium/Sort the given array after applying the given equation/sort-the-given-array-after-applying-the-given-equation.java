//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        int i = 0, j = n - 1;
        int index = (A >= 0) ? n - 1 : 0;

        while (i <= j) {
            int val1 = transform(arr[i], A, B, C);
            int val2 = transform(arr[j], A, B, C);

            if (A >= 0) {
                if (val1 > val2) {
                    result.set(index--, val1);
                    i++;
                } else {
                    result.set(index--, val2);
                    j--;
                }
            } else {
                if (val1 < val2) {
                    result.set(index++, val1);
                    i++;
                } else {
                    result.set(index++, val2);
                    j--;
                }
            }
        }

        return result;
    }

    private int transform(int x, int A, int B, int C) {
        return A * x * x + B * x + C;
    }
}
