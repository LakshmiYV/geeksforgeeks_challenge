//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java
class Solution {
    static int sameOccurrence(int arr[], int x, int y) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int countX = 0, countY = 0, result = 0;

        // Initial difference count for zero occurrences
        countMap.put(0, 1);

        for (int num : arr) {
            if (num == x) {
                countX++;
            } else if (num == y) {
                countY++;
            }

            // Calculate the current difference
            int diff = countX - countY;

            // If this difference has been seen before, it means there are subarrays
            // that have equal occurrences of x and y
            result += countMap.getOrDefault(diff, 0);

            // Update the count of this difference in the hashmap
            countMap.put(diff, countMap.getOrDefault(diff, 0) + 1);
        }

        return result;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends