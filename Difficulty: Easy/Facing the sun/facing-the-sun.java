//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputStrings = input.split(" ");
            int[] height = new int[inputStrings.length];
            for (int i = 0; i < inputStrings.length; i++) {
                height[i] = Integer.parseInt(inputStrings[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countBuildings(height);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countBuildings(int[] height) {
        int count = 1; // First building always sees the sunrise
        int maxHeight = height[0]; // Initialize maxHeight to the height of the first building

        // Iterate through the rest of the buildings
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxHeight) {
                count++; // This building can see the sunrise
                maxHeight = height[i]; // Update maxHeight to the current building's height
            }
        }
        return count; // Return the total count of buildings that can see the sunrise
    }
}
