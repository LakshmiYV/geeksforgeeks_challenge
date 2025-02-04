//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


class Solution {
    // Helper class to store information about a subtree
    static class SubtreeInfo {
        boolean isBST; // Whether the subtree is a BST
        int size;      // Size of the subtree
        int min;       // Minimum value in the subtree
        int max;       // Maximum value in the subtree

        SubtreeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    // Function to find the size of the largest BST in the given binary tree
    static int largestBst(Node root) {
        return helper(root).size;
    }

    // Helper function to perform post-order traversal and return SubtreeInfo
    static SubtreeInfo helper(Node node) {
        // Base case: If the node is null, it is a BST of size 0
        if (node == null) {
            return new SubtreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursively get information about the left and right subtrees
        SubtreeInfo left = helper(node.left);
        SubtreeInfo right = helper(node.right);

        // Check if the current subtree is a BST
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            // Current subtree is a BST
            int size = left.size + right.size + 1;
            int minVal = Math.min(node.data, left.min);
            int maxVal = Math.max(node.data, right.max);
            return new SubtreeInfo(true, size, minVal, maxVal);
        } else {
            // Current subtree is not a BST
            // Return the size of the largest BST found in the left or right subtree
            int size = Math.max(left.size, right.size);
            return new SubtreeInfo(false, size, 0, 0);
        }
    }
}