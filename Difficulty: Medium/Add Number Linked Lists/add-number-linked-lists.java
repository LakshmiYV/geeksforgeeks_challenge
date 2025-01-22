//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    // Function to reverse the linked list.
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {

        // reversing both lists to simplify addition.
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = null;
        int carry = 0;

        // using a loop till both lists and carry gets exhausted.
        while (num1 != null || num2 != null || carry > 0) {
            // using a variable to store sum of two digits along with carry.
            int newVal = carry;

            // if nodes are left in any list, we add their data in newVal.
            if (num1 != null) newVal += num1.data;
            if (num2 != null) newVal += num2.data;

            // updating carry.
            carry = newVal / 10;

            // using modulus to store only a single digit at that place.
            newVal = newVal % 10;

            // creating new node which gets connected with other nodes that
            // we get after calculating sum of respective digits.
            Node newNode = new Node(newVal);

            // storing the previously made nodes in the link part of new node.
            newNode.next = sum;
            // making the new node as the num1 node of all previously made node.
            sum = newNode;

            // moving ahead in both lists.
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        while (sum != null && sum.data == 0) {
            Node temp = sum.next;
            sum.next = null;
            sum = temp;
        }
        if (sum == null) return new Node(0);
        return sum;
    }
}



//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends