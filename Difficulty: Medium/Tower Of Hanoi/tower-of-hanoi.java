//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}

// } Driver Code Ends


class Hanoi {
    public long toh(int n, int from, int to, int aux) {
        // List to store the moves
        List<String> moves = new ArrayList<>();
        // Solve the problem
        solve(n, from, to, aux, moves);
        // Print all the moves
        for (String move : moves) {
            System.out.println(move);
        }
        // Return the total number of moves
        return moves.size();
    }

    private void solve(int n, int from, int to, int aux, List<String> moves) {
        if (n == 0) {
            return;
        }
        // Move n-1 disks from 'from' to 'aux'
        solve(n - 1, from, aux, to, moves);
        // Move the nth disk from 'from' to 'to'
        moves.add("move disk " + n + " from rod " + from + " to rod " + to);
        // Move n-1 disks from 'aux' to 'to'
        solve(n - 1, aux, to, from, moves);
    }
}

