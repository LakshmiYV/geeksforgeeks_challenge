//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // HashMap to store frequency of prefix XORs
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int prefixXor = 0; // Running prefix XOR
        long count = 0;

        // Initialize map for edge case where subarray starts from the beginning
        freqMap.put(0, 1);

        for (int num : arr) {
            // Update prefix XOR
            prefixXor ^= num;

            // Check if there's a prefix XOR that would give XOR as 'k'
            int requiredXor = prefixXor ^ k;
            if (freqMap.containsKey(requiredXor)) {
                count += freqMap.get(requiredXor);
            }

            // Update the frequency map for the current prefix XOR
            freqMap.put(prefixXor, freqMap.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
