class Solution {
    public static void transformTree(Node root) {
        transform(root, 0);
    }
    private static int transform(Node node, int acc) {
        if (node == null) return acc;
        acc = transform(node.right, acc);
        int old = node.data;
        node.data = acc;
        acc += old;
        acc = transform(node.left, acc);
        return acc;
    }
}
