//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the subarray with given sum
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();

        int start = 0;
        int currentSum = 0;

        // Iterate over the array
        for (int end = 0; end < n; end++) {
            // Add current element to currentSum
            currentSum += arr[end];

            // If currentSum exceeds the sum, remove elements from start
            while (currentSum > s && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // If currentSum equals the target sum, return the result
            if (currentSum == s) {
                result.add(start + 1); // Convert to 1-based index
                result.add(end + 1);   // Convert to 1-based index
                return result;
            }
        }

        // If no subarray found, return -1
        result.add(-1);
        return result;
    }
}

