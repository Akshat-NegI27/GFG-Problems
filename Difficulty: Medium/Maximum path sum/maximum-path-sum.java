class Solution {
    int maxSum;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPath(root);
        return maxSum;
    }

    private int maxPath(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));

        maxSum = Math.max(maxSum, node.data + left + right);

        return node.data + Math.max(left, right);
    }
}
