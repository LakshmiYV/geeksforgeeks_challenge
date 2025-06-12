import java.util.*;

class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // Max heap with custom comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]); // smaller diff first
                return Integer.compare(b[1], a[1]);     // larger value first if tie
            }
        );

        for (int val : arr) {
            if (val == x) continue; // exclude x
            pq.offer(new int[]{Math.abs(val - x), val});
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }
}
