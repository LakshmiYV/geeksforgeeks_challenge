//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int gap = (n + m + 1) / 2; // Initial gap

        while (gap > 0) {
            int i = 0, j = gap;

            // Compare within a[]
            while (j < n) {
                if (a[i] > a[j]) {
                    // Swap a[i] and a[j]
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                i++;
                j++;
            }

            // Compare between a[] and b[]
            j = j - n; // Adjust j to point to b[]
            while (i < n && j < m) {
                if (a[i] > b[j]) {
                    // Swap a[i] and b[j]
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }

            // Compare within b[]
            i = 0;
            while (j < m) {
                if (b[i] > b[j]) {
                    // Swap b[i] and b[j]
                    int temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }

            // Reduce the gap
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (gap + 1) / 2;
            }
        }
    }
}

