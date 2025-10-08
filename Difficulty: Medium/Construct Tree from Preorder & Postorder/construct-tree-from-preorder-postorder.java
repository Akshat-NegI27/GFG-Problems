class Solution {
    int preIndex = 0;
    Map<Integer, Integer> postMap;

    public Node constructTree(int[] pre, int[] post) {
        int n = pre.length;
        postMap = new HashMap<>();
        for (int i = 0; i < n; i++) postMap.put(post[i], i);
        return build(pre, post, 0, n - 1);
    }

    private Node build(int[] pre, int[] post, int l, int r) {
        if (preIndex >= pre.length || l > r) return null;

        Node root = new Node(pre[preIndex++]);
        if (l == r || preIndex >= pre.length) return root;

        int nextVal = pre[preIndex];
        int idx = postMap.get(nextVal);

        root.left = build(pre, post, l, idx);
        root.right = build(pre, post, idx + 1, r - 1);

        return root;
    }
}