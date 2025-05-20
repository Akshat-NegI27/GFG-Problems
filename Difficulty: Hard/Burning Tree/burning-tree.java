/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}  */


class Solution {
    int max = -1;

    private static class Pair {
        int height;
        boolean found;

        Pair(int height, boolean found) {
            this.height = height;
            this.found = found;
        }
    }

    public int minTime(Node root, int target) {
        helper(root, target);
        return max;
    }

    private Pair helper(Node root, int target) {
        if (root == null) {
            return new Pair(0, false);
        }

        Pair left = helper(root.left, target);
        Pair right = helper(root.right, target);

        if (root.data == target) {
            max = Math.max(left.height, right.height);
            return new Pair(0, true);
        }

        if (left.found || right.found) {
            max = Math.max(max, (left.found ? left.height : right.height) + 
                                (left.found ? right.height : left.height) + 1);
            return new Pair((left.found ? left.height : right.height) + 1, true);
        }

        return new Pair(Math.max(left.height, right.height) + 1, false);
    }
}
