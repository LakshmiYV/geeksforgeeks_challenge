//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

import java.util.*;

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        // Create job objects
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }

        // Create a slot array to keep track of available slots
        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int maxProfit = 0, countJobs = 0;

        // Assign jobs greedily
        for (Job job : jobs) {
            // Find the latest available slot before deadline
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == -1) {  // If slot is free
                    slots[j] = job.profit; // Assign job to this slot
                    maxProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(countJobs, maxProfit));
    }
}

// Helper class to store job details
class Job {
    int deadline, profit;
    Job(int d, int p) {
        this.deadline = d;
        this.profit = p;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends