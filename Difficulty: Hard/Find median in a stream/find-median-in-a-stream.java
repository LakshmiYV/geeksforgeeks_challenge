//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min Heap
        
        for (int num : arr) {
            // Step 1: Insert number into appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            
            // Step 2: Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            // Step 3: Calculate the median
            if (maxHeap.size() > minHeap.size()) {
                result.add((double) maxHeap.peek());
            } else {
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
        
        return result;
    }
}
