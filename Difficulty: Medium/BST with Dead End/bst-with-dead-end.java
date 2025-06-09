/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return helper(root, 1, Integer.MAX_VALUE);
    }

    private boolean helper(Node node, int min, int max) {
        if (node == null)
            return false;

        if (min == max)
            return true;

        return helper(node.left, min, node.data - 1) ||
               helper(node.right, node.data + 1, max);
    }
}
