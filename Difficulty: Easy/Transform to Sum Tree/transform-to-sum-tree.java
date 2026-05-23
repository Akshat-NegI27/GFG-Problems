class Solution {
    public void toSumTree(Node root) {
        solve(root);
    }

    int solve(Node root) {
        if (root == null) {
            return 0;
        }

        int oldValue = root.data;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        root.data = leftSum + rightSum;

        return oldValue + root.data;
    }
}