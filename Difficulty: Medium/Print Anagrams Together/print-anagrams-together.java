//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Create a LinkedHashMap to store grouped anagrams
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        // Iterate through each word in the array
        for (String word : arr) {
            // Sort the characters of the word to create a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add the word to the corresponding group in the map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        // Prepare the final result as a list of groups
        return new ArrayList<>(map.values());
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends