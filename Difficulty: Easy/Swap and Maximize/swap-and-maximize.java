//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java



class Solution {
    public long maxSum(Long[] arr) {
        // Sort the array to arrange elements in small-large order
        Arrays.sort(arr);

        int n = arr.length;
        Long[] reorderedArr = new Long[n];
        
        int left = 0;    // Pointer for smallest elements
        int right = n - 1; // Pointer for largest elements
        int index = 0;

        // Alternately place largest and smallest elements
        while (left <= right) {
            if (index < n) reorderedArr[index++] = arr[left++];
            if (index < n) reorderedArr[index++] = arr[right--];
        }

        // Calculate the sum of absolute differences for reorderedArr
        long maxSum = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSum += Math.abs(reorderedArr[i] - reorderedArr[i + 1]);
        }
        // Adding the difference between the last and first elements (circular property)
        maxSum += Math.abs(reorderedArr[n - 1] - reorderedArr[0]);

        return maxSum;
    }
}



//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends