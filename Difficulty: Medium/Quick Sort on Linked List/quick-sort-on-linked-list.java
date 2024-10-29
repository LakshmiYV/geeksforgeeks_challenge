//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


class GfG {
    // Function to perform quicksort on a linked list
    public static Node quickSort(Node node) {
        // Initialize the last node as the tail
        node = quickSortRec(node, getTail(node));

        return node;
    }

    // Function to get the tail node of the linked list
    public static Node getTail(Node n) {
        // Iterate through the linked list to find the last node
        while (n != null && n.next != null) n = n.next;

        return n;
    }

    // Inner class to store the new head and new end of a partition
    static class Res { Node newHead = null, newEnd = null; }

    // Recursive function to perform quicksort on the linked list
    public static Node quickSortRec(Node head, Node last) {
        // Base case: if the list is empty or has only one element, return the list
        if (head == null || head == last) return head;

        // Create two result objects to store the partition
        Res r = new Res();
        Res s = new Res();

        // Partition the list and get the pivot node
        Node pivot = partition(head, last, r, s);

        // If the new head of the left partition is not the pivot,
        // rearrange the nodes to maintain the correct order
        if (r.newHead != pivot) {
            Node tmp = r.newHead;
            while (tmp.next != pivot) tmp = tmp.next;
            tmp.next = null;

            // Recursively sort the left partition
            r.newHead = quickSortRec(r.newHead, tmp);

            // Get the tail of the sorted left partition and connect it to the pivot
            tmp = getTail(r.newHead);
            tmp.next = pivot;
        }

        // Recursively sort the right partition
        pivot.next = quickSortRec(pivot.next, s.newEnd);

        // Return the head of the sorted list
        return r.newHead;
    }

    // Function to partition the list around a pivot element
    public static Node partition(Node head, Node last, Res r, Res s) {
        // Choose the last node as the pivot node
        Node pivot = last;
        Node prev = null, cur = head, tail = pivot;

        // Iterate through the list and rearrange the nodes based on the pivot
        while (cur != pivot) {
            if (cur.data < pivot.data) {
                // If the current node is smaller than the pivot,
                // move it to the left partition
                if (r.newHead == null) r.newHead = cur;

                prev = cur;
                cur = cur.next;
            } else {
                // If the current node is greater than the pivot,
                // move it to the right partition
                if (prev != null) prev.next = cur.next;

                Node tmp = cur.next;
                cur.next = null;
                tail.next = cur;
                tail = cur;
                cur = tmp;
            }
        }

        // If no node was moved to the left partition,
        // set the pivot as the new head
        if (r.newHead == null) r.newHead = pivot;

        // Set the new end of the right partition
        s.newEnd = tail;

        // Return the pivot node
        return pivot;
    }
}
