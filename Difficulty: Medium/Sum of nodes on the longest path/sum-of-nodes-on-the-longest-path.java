class Solution {
    int maxLen = 0;
    int maxSum = 0;

    public int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);
        return maxSum;
    }

    private void dfs(Node node, int currLen, int currSum) {
        if (node == null) return;

        currLen += 1;
        currSum += node.data;

        // Check if it's a leaf node
        if (node.left == null && node.right == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen) {
                maxSum = Math.max(maxSum, currSum);
            }
            return;
        }

        // Recurse left and right
        dfs(node.left, currLen, currSum);
        dfs(node.right, currLen, currSum);
    }
}
