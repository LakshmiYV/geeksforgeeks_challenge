//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
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

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    // Function to split a linked list into two alternating lists
    Node[] alternatingSplitList(Node head) {
        // Two dummy nodes to help in easily building two sublists
        Node dummy1 = new Node(-1); // For the first sublist
        Node dummy2 = new Node(-1); // For the second sublist
        
        Node curr1 = dummy1; // Pointer for the first sublist
        Node curr2 = dummy2; // Pointer for the second sublist
        
        Node curr = head; // Pointer to traverse the original list
        boolean toggle = true; // This will help in alternately adding nodes
        
        // Traverse the list
        while (curr != null) {
            if (toggle) {
                // Add to the first sublist
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                // Add to the second sublist
                curr2.next = curr;
                curr2 = curr2.next;
            }
            toggle = !toggle; // Switch between lists
            curr = curr.next; // Move to the next node
        }
        
        // At the end, terminate both lists
        curr1.next = null;
        curr2.next = null;
        
        // Return the heads of both lists (dummy nodes' next)
        return new Node[] { dummy1.next, dummy2.next };
    }
}

