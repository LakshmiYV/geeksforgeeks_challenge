//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int longestStringChain(String words[]) {
        // Sort words based on their lengths
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // HashMap to store the longest chain ending at each word
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 1;

        for (String word : words) {
            int longest = 1; // At minimum, a word forms a chain of length 1
            
            // Try removing each character and check if it exists in dp
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                longest = Math.max(longest, dp.getOrDefault(predecessor, 0) + 1);
            }
            
            dp.put(word, longest);
            maxLength = Math.max(maxLength, longest);
        }

        return maxLength;
    }
}
