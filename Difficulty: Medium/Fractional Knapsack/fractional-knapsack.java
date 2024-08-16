//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]),
                                  Integer.parseInt(inputLine[k++]));
            }
            System.out.println(
                String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double)a.value / (double)a.weight;
                double r2 = (double)b.value / (double)b.weight;
                return Double.compare(r2, r1);  // Sort in descending order
            }
        });

        double totalValue = 0.0;  // Variable to store the total value of the knapsack
        int currentWeight = 0;    // Current weight in the knapsack

        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                // If the item can be added completely
                currentWeight += arr[i].weight;
                totalValue += arr[i].value;
            } else {
                // If the item can't be added completely, take the fractional part
                int remain = W - currentWeight;
                totalValue += (arr[i].value / (double)arr[i].weight) * remain;
                break;  // Knapsack is full
            }
        }

        return totalValue;  // Return the total value
    }
}
