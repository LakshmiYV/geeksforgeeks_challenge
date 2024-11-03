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

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null) return null;

        Node current = head, prev = null;

        // Case 1: If head node itself holds the key
        if (head.data == key) {
            if (head.next == head) { // Only one node in the list
                return null; // List becomes empty
            }
            // Find the last node
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            // Update head to the next node and set last node's next to new head
            head = head.next;
            last.next = head;
            return head;
        }

        // Case 2: If key is somewhere other than at head
        do {
            prev = current;
            current = current.next;
            if (current.data == key) {
                prev.next = current.next;
                return head;
            }
        } while (current != head);

        // If key not found, return the original head
        return head;
    }

    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head) return head;

        Node prev = null;
        Node current = head;
        Node next = null;
        Node last = head; // We need to know the last node after reversal

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        // Complete the circular link
        head.next = prev;
        head = prev;

        return head;
    }
}
