//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // List to hold the meeting timings
        List<Meeting> meetings = new ArrayList<>();
        
        // Populating the meeting list with start and end times
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        
        // Sorting meetings based on end times
        Collections.sort(meetings, (a, b) -> a.end - b.end);
        
        // Variable to track the end time of the last selected meeting
        int lastEndTime = 0;
        // Variable to count the number of meetings that can be attended
        int count = 0;
        
        // Iterate through the sorted meetings
        for (Meeting meeting : meetings) {
            // If the start time of the current meeting is greater than the
            // end time of the last attended meeting, we can attend this meeting
            if (meeting.start > lastEndTime) {
                // Update the last end time to the end time of the current meeting
                lastEndTime = meeting.end;
                // Increment the count of meetings attended
                count++;
            }
        }
        
        return count;
    }
}

// Helper class to store meeting timings
class Meeting {
    int start;
    int end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

