//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<String> findPermutation(String s) {
        // List to store the unique permutations
        ArrayList<String> result = new ArrayList<>();

        // Convert the string to a character array and sort it to handle duplicates
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Track whether a character is used in the current permutation
        boolean[] used = new boolean[s.length()];

        // Build the permutations using backtracking
        backtrack(chars, used, new StringBuilder(), result);

        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder current, ArrayList<String> result) {
        // Base case: if the current permutation is complete, add it to the result
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        // Iterate through the characters
        for (int i = 0; i < chars.length; i++) {
            // Skip if the character is already used or if it's a duplicate and the previous duplicate has not been used
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }

            // Mark the character as used
            used[i] = true;
            current.append(chars[i]);

            // Recurse to build the next character in the permutation
            backtrack(chars, used, current, result);

            // Backtrack: remove the character and mark it as unused
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
