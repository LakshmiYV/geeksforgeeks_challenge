//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends



class Solution {
    public int maxDistance(int[] arr) {
        // HashMap to store the first occurrence index of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxDist = 0;
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is seen for the first time, store its index
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                // If the element is seen again, calculate the distance
                int dist = i - map.get(arr[i]);
                maxDist = Math.max(maxDist, dist);
            }
        }
        
        return maxDist;
    }
}





//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends