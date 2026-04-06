import java.util.*;

class Solution {

    static class Node {
        int data;
        int idx;
        Node left;
        Node right;

        Node(int data, int idx) {
            this.data = data;
            this.idx = idx;
            this.left = null;
            this.right = null;
        }
    }

    void solve(Node root, String s, ArrayList<String> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (s.length() == 0) {
                s = "0";
            }
            ans.add(s);
            return;
        }

        solve(root.left, s + "0", ans);
        solve(root.right, s + "1", ans);
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.data == b.data)
                return a.idx - b.idx;
            return a.data - b.data;
        });

        for (int i = 0; i < f.length; i++) {
            minHeap.add(new Node(f[i], i));
        }

        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            Node node = new Node(left.data + right.data, Math.min(left.idx, right.idx));
            node.left = left;
            node.right = right;

            minHeap.add(node);
        }

        Node root = minHeap.poll();

        ArrayList<String> ans = new ArrayList<>();
        solve(root, "", ans);

        return ans;
    }
}