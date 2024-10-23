//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}


// } Driver Code Ends


class Solution {
    // Function to return the sum of last n nodes in the linked list
    public int sumOfLastN_Nodes(Node head, int n) {
        if (head == null) {
            return 0;
        }

        // Step 1: Initialize two pointers
        Node first = head;
        Node second = head;

        // Step 2: Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        // Step 3: Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 4: Sum the last n nodes starting from the second pointer
        int sum = 0;
        while (second != null) {
            sum += second.data;
            second = second.next;
        }

        // Step 5: Return the result
        return sum;
    }
}



//{ Driver Code Starts.

class LinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int n = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.sumOfLastN_Nodes(head, n));
        }
    }
}

// } Driver Code Ends