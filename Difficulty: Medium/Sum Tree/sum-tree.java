//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.isSumTree(root));
            // if (g.isSumTree(root) == true)
            //     System.out.println(1);
            // else
            //     System.out.println(0);
            t--;
        }
    }
}

// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    boolean isSumTree(Node root) {
        // Use a helper function to check the Sum Tree property
        return checkSumTree(root) != -1;
    }
    
    private int checkSumTree(Node node) {
        if (node == null) {
            return 0;
        }
        
        // If the node is a leaf node, return its value
        if (node.left == null && node.right == null) {
            return node.data;
        }
        
        // Recursively check the left and right subtrees
        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);
        
        // If either left or right subtree is not a Sum Tree, propagate the failure
        if (leftSum == -1 || rightSum == -1) {
            return -1;
        }
        
        // Check if the current node satisfies the Sum Tree property
        if (node.data == leftSum + rightSum) {
            // Return the sum of values under this node (node's value + its subtree sums)
            return node.data + leftSum + rightSum;
        } else {
            // This node doesn't satisfy the Sum Tree property
            return -1;
        }
    }
}

