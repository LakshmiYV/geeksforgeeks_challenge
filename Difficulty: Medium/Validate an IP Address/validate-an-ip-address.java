//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean isValid(String str) {
        // Split the string by dots
        String[] parts = str.split("\\.");

        // Check if there are exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // Check if part is empty or not a number
            if (part.isEmpty() || !part.matches("\\d+")) {
                return false;
            }

            // Check if the number is within the range 0-255
            int num;
            try {
                num = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                return false;
            }

            if (num < 0 || num > 255) {
                return false;
            }

            // Check for leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
        }

        return true;
    }
}
