//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends



class Solution {

    // Function to swap once in case of mismatch
    public void doOneSwap(int n, List<Integer> arr) {
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) {
                for (int j = i + 1; j < n; j++) {
                    if (arr.get(j) == i + 1) {
                        Collections.swap(arr, i, j);
                        return;
                    }
                }
            }
        }
    }

    // Function to check if sorted or can be sorted with a maximum of two swaps
    public boolean checkSorted(List<Integer> arr) {
        int n = arr.size();
        int misMatch = 0;

        // Count mismatches
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) misMatch++;
        }

        // Edge case if size is 1
        if (n == 1) return false;

        // If already sorted or only 3 mismatches
        if (misMatch == 0 || misMatch == 3) return true;

        // If mismatches are not exactly 4, return false
        if (misMatch != 4) return false;

        // Perform two swaps
        doOneSwap(n, arr);
        doOneSwap(n, arr);

        // Final check if sorted
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != i + 1) return false;
        }
        return true;
    }
}