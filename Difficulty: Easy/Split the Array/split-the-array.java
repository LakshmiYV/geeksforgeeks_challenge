//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    // Function to calculate (x^y) % p using binary exponentiation
    public static int power(int x, int y, int p) {
        int result = 1;
        x = x % p; // Ensure x is within mod range

        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % p; // If y is odd, multiply x with result
            }
            y = y >> 1;      // y = y / 2
            x = (x * x) % p; // x = x^2 % p
        }
        return result;
    }

    // Function to count the number of ways to split array into two groups such that
    // each group has equal XOR value.
    public static int countgroup(int[] arr) {
        int mod = 1000000007; // Define the mod value
        int n = arr.length;   // Get the size of the input array
        int xs = 0;           // Initialize XOR sum

        // Compute the XOR of the entire array
        for (int i = 0; i < n; i++) {
            xs ^= arr[i];
        }

        // We can split only if the XOR of the entire array is 0
        if (xs == 0) {
            // If XOR of the whole array is 0, calculate 2^(n-1) - 1
            int ans = power(2, n - 1, mod) - 1;
            if (ans < 0) {
                ans += mod; // Ensure the answer is non-negative
            }
            return ans;
        }

        return 0; // If XOR isn't 0, we cannot split the array
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends