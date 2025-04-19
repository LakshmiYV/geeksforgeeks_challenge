//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Node {
    Node one;
    Node zero;

    Node() {
        one = null;
        zero = null;
    }
}

class Trie {
    Node root;

    Trie() { root = new Node(); }

    // Function to insert in Trie
    void insert(int n) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;

            // Check if the bit is 0
            if (bit == 0) {
                if (curr.zero == null) {
                    curr.zero = new Node();
                }
                curr = curr.zero;
            }

            // Else if bit is 1
            else {
                if (curr.one == null) {
                    curr.one = new Node();
                }
                curr = curr.one;
            }
        }
    }

    // Function to find element having
    // the maximum XOR with value n
    int findXOR(int n) {
        Node curr = root;
        int res = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;

            // if the bit is 0
            if (bit == 0) {

                // if set bit is present
                if (curr.one != null) {
                    curr = curr.one;
                    res += (1 << i);
                } else {
                    curr = curr.zero;
                }
            }

            // Else if bit is 1
            else {

                // if unset bit is present
                if (curr.zero != null) {
                    curr = curr.zero;
                    res += (1 << i);
                } else {
                    curr = curr.one;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int maxXor(int[] arr) {
        int res = 0;

        Trie t = new Trie();

        // insert the first element in trie
        t.insert(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            res = Math.max(t.findXOR(arr[i]), res);
            t.insert(arr[i]);
        }
        return res;
    }
}