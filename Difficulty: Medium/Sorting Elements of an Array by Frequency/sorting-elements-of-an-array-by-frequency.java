//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to the frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Step 1: Count the frequency of each element
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert the elements to a list of pairs (frequency, element)
        List<int[]> freqList = new ArrayList<>();
        for (int num : freqMap.keySet()) {
            freqList.add(new int[]{freqMap.get(num), num});
        }

        // Step 3: Sort the list first by frequency (descending), then by element value (ascending)
        Collections.sort(freqList, (a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0]; // Sort by frequency in descending order
            } else {
                return a[1] - b[1]; // If frequencies are the same, sort by element value in ascending order
            }
        });

        // Step 4: Reconstruct the sorted array
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] pair : freqList) {
            int frequency = pair[0];
            int element = pair[1];
            for (int i = 0; i < frequency; i++) {
                result.add(element);
            }
        }

        return result;
    }
}


//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends