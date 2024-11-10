//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < a.length && j < b.length) {
            // Skip duplicates in the result
            if (!result.isEmpty() && result.get(result.size() - 1) == a[i]) {
                i++;
                continue;
            }
            if (!result.isEmpty() && result.get(result.size() - 1) == b[j]) {
                j++;
                continue;
            }
            
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                result.add(b[j]);
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        
        // Add remaining elements from array a
        while (i < a.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }
        
        // Add remaining elements from array b
        while (j < b.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }
        
        return result;
    }
}

