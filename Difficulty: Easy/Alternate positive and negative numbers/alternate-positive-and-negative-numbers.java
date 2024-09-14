//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        // Separate positive and negative elements
        for (int num : arr) {
            if (num >= 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        // Merging them alternately into the original array
        int i = 0, pos = 0, neg = 0;
        boolean flag = true;  // Start with positive number

        // Alternate between positive and negative numbers
        while (pos < positive.size() && neg < negative.size()) {
            if (flag) {
                arr.set(i++, positive.get(pos++));
            } else {
                arr.set(i++, negative.get(neg++));
            }
            flag = !flag;  // Toggle the flag to alternate
        }

        // If there are remaining positive numbers
        while (pos < positive.size()) {
            arr.set(i++, positive.get(pos++));
        }

        // If there are remaining negative numbers
        while (neg < negative.size()) {
            arr.set(i++, negative.get(neg++));
        }
    }
}
