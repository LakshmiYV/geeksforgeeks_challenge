//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends



class Solution {
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2) {
        // If the lengths of the strings are not the same, they cannot be isomorphic.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create two maps to store the mappings of characters.
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        // Iterate through each character of the strings.
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            // Check if char1 is already mapped to some other character.
            if (map1.containsKey(char1)) {
                // If char1 is mapped to a different character, return false.
                if (map1.get(char1) != char2) {
                    return false;
                }
            } else {
                // Map char1 to char2.
                map1.put(char1, char2);
            }

            // Check if char2 is already mapped to some other character.
            if (map2.containsKey(char2)) {
                // If char2 is mapped to a different character, return false.
                if (map2.get(char2) != char1) {
                    return false;
                }
            } else {
                // Map char2 to char1.
                map2.put(char2, char1);
            }
        }

        // If we reach here, it means the strings are isomorphic.
        return true;
    }
}
