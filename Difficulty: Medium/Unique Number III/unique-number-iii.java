//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int getSingle(int[] arr) {
        int result = 0;

        // iterate over every bit position
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            int bitMask = 1 << i;

            for (int num : arr) {
                if ((num & bitMask) != 0) {
                    bitCount++;
                }
            }

            // If bitCount % 3 != 0, this bit is set in the single number
            if (bitCount % 3 != 0) {
                result |= bitMask;
            }
        }

        return result;
    }
}
