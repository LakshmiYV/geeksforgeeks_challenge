//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA


class Solution {
    // Function to check if a string is Pangram or not.
    public static boolean checkPangram(String s) {
        // Create a set to store unique characters.
        HashSet<Character> set = new HashSet<>();

        // Iterate through each character in the string.
        for (char c : s.toCharArray()) {
            // If the character is a letter, convert it to lowercase and add it to the set.
            if (Character.isLetter(c)) {
                set.add(Character.toLowerCase(c));
            }
        }

        // Check if the set contains all 26 letters of the English alphabet.
        return set.size() == 26;
    }
}


//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends