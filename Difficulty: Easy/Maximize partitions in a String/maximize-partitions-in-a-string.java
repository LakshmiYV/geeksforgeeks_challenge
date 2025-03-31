//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    public int maxPartitions(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        
        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        
        int partitions = 0;
        int partitionEnd = 0;
        
        // Traverse and count partitions
        for (int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence.get(s.charAt(i)));
            if (i == partitionEnd) { // Found a valid partition
                partitions++;
            }
        }
        
        return partitions;
    }
}
