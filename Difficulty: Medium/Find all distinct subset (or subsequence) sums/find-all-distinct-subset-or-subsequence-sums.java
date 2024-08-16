//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public int[] DistinctSum(int[] nums) {
        // A set to store all distinct sums
        Set<Integer> sums = new HashSet<>();
        // Start with the sum 0
        sums.add(0);
        
        // Iterate over each number in nums
        for (int num : nums) {
            // Create a temporary set to store new sums
            Set<Integer> newSums = new HashSet<>();
            // Add the current number to each of the existing sums
            for (int sum : sums) {
                newSums.add(sum + num);
            }
            // Add all new sums to the main set of sums
            sums.addAll(newSums);
        }
        
        // Convert the set of sums into a list and sort it
        List<Integer> result = new ArrayList<>(sums);
        Collections.sort(result);
        
        // Convert the list to an array and return it
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}
