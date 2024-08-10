//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
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
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;
        
        // Calculate the length of the linked list
        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        // If k is equal to the length of the list, return the list as it is
        if (k >= length) k = k % length;
        if (k == 0) return head;
        
        // Connect the last node to the head, making it a circular list
        current.next = head;
        
        // Traverse to the (k-1)th node
        for (int i = 0; i < k; i++) {
            current = current.next;
        }
        
        // The new head is the next of the k-th node
        head = current.next;
        current.next = null; // Break the circular link
        
        return head;
    }
}



//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends