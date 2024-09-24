//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static String smallestWindow(String s, String p)
    {
        // Edge case: if p is longer than s, return -1
        if(s.length() < p.length()) return "-1";
        
        // Step 1: Create frequency map for string p
        int[] mapP = new int[256]; // to handle all characters, even non-alphabetic
        for(int i = 0; i < p.length(); i++) {
            mapP[p.charAt(i)]++;
        }
        
        // Step 2: Initialize sliding window variables
        int[] windowMap = new int[256];
        int minLength = Integer.MAX_VALUE;
        int start = 0; // to keep track of the start of the minimum window
        int left = 0;
        int count = 0; // count of characters matched

        // Step 3: Slide the window using the right pointer
        for(int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);
            windowMap[charRight]++;

            // If the current character is part of p and matches the frequency requirement, increase count
            if(mapP[charRight] != 0 && windowMap[charRight] <= mapP[charRight]) {
                count++;
            }
            
            // Step 4: Once all characters of p are matched, try to shrink the window
            while(count == p.length()) {
                // Update minimum window length if found a smaller valid window
                if(minLength > right - left + 1) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Shrink the window by moving left pointer
                char charLeft = s.charAt(left);
                windowMap[charLeft]--;
                
                // If the left character was part of p and is now insufficient in the window, decrease count
                if(mapP[charLeft] != 0 && windowMap[charLeft] < mapP[charLeft]) {
                    count--;
                }

                left++;
            }
        }

        // Step 5: If no valid window is found, return -1. Else return the smallest window
        return minLength == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minLength);
    }
}
