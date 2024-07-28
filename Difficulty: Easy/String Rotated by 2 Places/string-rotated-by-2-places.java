//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution {
    // Function to check if a string can be obtained by rotating another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2) {
        // If the lengths of the strings are not the same, they cannot be rotations of each other.
        if (str1.length() != str2.length()) {
            return false;
        }

        // If the length of the strings is less than 2, they cannot be rotated by 2 places.
        if (str1.length() < 2) {
            return str1.equals(str2);
        }

        // Rotate str1 to the left by 2 places
        String leftRotate = str1.substring(2) + str1.substring(0, 2);
        // Rotate str1 to the right by 2 places
        String rightRotate = str1.substring(str1.length() - 2) + str1.substring(0, str1.length() - 2);

        // Check if either rotation matches str2
        return str2.equals(leftRotate) || str2.equals(rightRotate);
    }
}
