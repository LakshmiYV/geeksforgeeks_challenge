class Solution {
    public int findMaxFork(Node root, int k) {
        int result = -1;  
        while (root != null) {
            if (root.data == k) {
                return root.data; 
            } else if (root.data < k) {
                result = root.data; 
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return result;
    }
}

