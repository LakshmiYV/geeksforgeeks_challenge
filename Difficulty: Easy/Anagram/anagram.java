//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        // Step 1: If lengths differ, they cannot be anagrams.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 2: Create frequency arrays for both strings.
        int[] freq = new int[26]; // Only lowercase English letters.

        // Step 3: Populate the frequency array for s1 and s2.
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++; // Increment for s1.
            freq[s2.charAt(i) - 'a']--; // Decrement for s2.
        }

        // Step 4: Check if all frequencies are zero.
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        // If we reach here, the strings are anagrams.
        return true;
    }
}
