//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // Base case
        if (b == 0) return 0; // Any power of 0 is 0

        // Handling negative exponent
        long exp = e; // Convert to long to handle Integer.MIN_VALUE safely
        if (exp < 0) {
            b = 1 / b;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            if (exp % 2 == 1) { // If exponent is odd, multiply result by base
                result *= b;
            }
            b *= b; // Square the base
            exp /= 2; // Reduce exponent by half
        }
        return result;
    }
}



//{ Driver Code Starts.
// } Driver Code Ends