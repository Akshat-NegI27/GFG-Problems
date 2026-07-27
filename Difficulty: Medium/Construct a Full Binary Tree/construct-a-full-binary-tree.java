/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private int preIdx;
    private HashMap<Integer, Integer> pos;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIdx = 0;
        pos = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            pos.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int l, int r) {
        if (preIdx >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIdx++]);

        if (l == r || preIdx >= pre.length)
            return root;

        int idx = pos.get(pre[preIdx]);

        root.left = build(pre, idx, r);
        root.right = build(pre, l + 1, idx - 1);

        return root;
    }
}