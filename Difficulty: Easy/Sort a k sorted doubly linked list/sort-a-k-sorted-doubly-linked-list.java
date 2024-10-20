//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to sort a k-sorted doubly linked list
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        if (head == null) {
            return null;
        }
        
        // Create a min-heap (priority queue)
        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        DLLNode newHead = null, last = null;  // To maintain the new sorted list
        
        // Step 1: Add first k+1 elements to the heap
        DLLNode current = head;
        for (int i = 0; i <= k && current != null; i++) {
            minHeap.add(current);
            current = current.next;
        }
        
        // Step 2: Process the nodes and rebuild the sorted list
        while (!minHeap.isEmpty()) {
            // Extract the minimum node from the heap
            DLLNode minNode = minHeap.poll();
            
            // If this is the first node, set it as newHead
            if (newHead == null) {
                newHead = minNode;
                newHead.prev = null;
                last = newHead;
            } else {
                // Attach the node to the sorted list
                last.next = minNode;
                minNode.prev = last;
                last = minNode;
            }
            
            // Step 3: Add the next node from the list to the heap (if available)
            if (current != null) {
                minHeap.add(current);
                current = current.next;
            }
        }
        
        // Set the last node's next pointer to null
        if (last != null) {
            last.next = null;
        }
        
        return newHead;
    }
}
