//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public List<Integer> findSplit(int[] arr) {
        List<Integer> result = new ArrayList<>(Arrays.asList(-1, -1));
        int totalSum = Arrays.stream(arr).sum();

        // If the total sum is not divisible by 3, return {-1, -1}
        if (totalSum % 3 != 0) return result;

        int partSum = totalSum / 3;
        int currentSum = 0;
        int firstSplit = -1, secondSplit = -1;

        // Loop through the array to find indices where the splits can occur
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Find the first split point
            if (currentSum == partSum && firstSplit == -1) {
                firstSplit = i;
            }
            // Find the second split point
            else if (currentSum == 2 * partSum && secondSplit == -1) {
                secondSplit = i;
                break;  // Once we find both splits, we can exit the loop
            }
        }

        // If both split points are found, return them
        if (firstSplit != -1 && secondSplit != -1) {
            result.set(0, firstSplit);
            result.set(1, secondSplit);
        }

        return result;
    }
}
