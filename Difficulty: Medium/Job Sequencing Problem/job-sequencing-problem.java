//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sort jobs in decreasing order of profit
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        // Initialize slots to keep track of free slots
        boolean[] slot = new boolean[n];
        
        // To keep track of the number of jobs and the total profit
        int numJobs = 0;
        int maxProfit = 0;
        
        // Process each job in the sorted order
        for (Job job : arr) {
            // Find a free slot for this job (if any)
            for (int j = Math.min(n, job.deadline) - 1; j >= 0; j--) {
                // If slot is free
                if (!slot[j]) {
                    // Assign this job to slot j
                    slot[j] = true;
                    numJobs++;
                    maxProfit += job.profit;
                    break;
                }
            }
        }
        
        // Return the result as an array of size 2
        return new int[] { numJobs, maxProfit };
    }
}


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/