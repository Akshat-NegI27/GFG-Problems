/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    int maxLen = 0;
    int maxSum = 0;

    public int sumOfLongRootToLeafPath(Node root) {
        solve(root, 0, 0);
        return maxSum;
    }

    void solve(Node node, int currSum, int currLen) {
        if (node == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen) {
                maxSum = Math.max(maxSum, currSum);
            }
            return;
        }
        solve(node.left, currSum + node.data, currLen + 1);
        solve(node.right, currSum + node.data, currLen + 1);
    }
}
