class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;

        int[] ple = new int[n]; // Previous Less Element
        int[] nle = new int[n]; // Next Less Element

        // Compute Previous Less Element (strictly less)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Compute Next Less Element (less than or equal to)
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Compute the sum of subarray minimums
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            sum = (sum + (arr[i] * left * right) % mod) % mod;
        }

        return (int)sum;
    }
}

