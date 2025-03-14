//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

class Solution {
    public void deleteAlt(Node head) {
        if (head == null) return;  // If the list is empty, return.
        
        Node current = head;
        
        // Traverse the list, deleting alternate nodes
        while (current != null && current.next != null) {
            // Point the current node to the next of next node, skipping one node
            current.next = current.next.next;
            // Move to the next node
            current = current.next;
        }
    }
}




//{ Driver Code Starts.

public class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);
            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); i++) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            ob.deleteAlt(head);
            printList(head);
        }
    }
}

// } Driver Code Ends