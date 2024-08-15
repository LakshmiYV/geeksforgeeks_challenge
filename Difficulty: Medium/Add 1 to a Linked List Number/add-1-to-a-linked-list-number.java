//{ Driver Code Starts
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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    // Helper function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // Step 1: Reverse the linked list
        head = reverseList(head);
        
        // Step 2: Add one to the reversed list
        Node current = head;
        int carry = 1; // we need to add 1
        
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            
            if (carry == 0) break; // No need to continue if no carry
            
            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }
            
            current = current.next;
        }
        
        // Step 3: Reverse the list again to restore original order
        head = reverseList(head);
        
        return head;
    }
}
