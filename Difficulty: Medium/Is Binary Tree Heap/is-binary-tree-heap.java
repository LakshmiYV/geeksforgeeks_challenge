//{ Driver Code Starts
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

public class GfG {

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

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution ob = new Solution();
            if (ob.isHeap(root))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end Complete Function template for JAVA

class Solution {
    // This function counts the number of nodes
    // in a binary tree
    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // This function checks if the binary tree is complete or not
    static boolean isCompleteUtil(Node root, int index, int numberOfNodes) {
        if (root == null) return true;

        // If index assigned to current node is more than
        // number of nodes in the tree, then the tree is not complete
        if (index >= numberOfNodes) return false;

        // Recur for left and right subtrees
        return isCompleteUtil(root.left, 2 * index + 1, numberOfNodes) &&
            isCompleteUtil(root.right, 2 * index + 2, numberOfNodes);
    }

    // This function checks the heap property in the tree.
    static boolean isHeapUtil(Node root) {
        if (root.left == null && root.right == null) return true;

        // Node will be in the second-last level
        if (root.right == null) {

            // Check heap property at the node
            // No recursive call because no need to
            // check the last level
            return root.data >= root.left.data;
        } else {

            // Check heap property at the node and recursively
            // check the heap property at left and right subtrees
            if (root.data >= root.left.data && root.data >= root.right.data)
                return isHeapUtil(root.left) && isHeapUtil(root.right);
            else
                return false;
        }
    }

    // Function to check if the tree is a valid heap
    boolean isHeap(Node tree) {
        int nodeCount = countNodes(tree);
        int index = 0;

        if (isCompleteUtil(tree, index, nodeCount) && isHeapUtil(tree)) return true;
        return false;
    }
}