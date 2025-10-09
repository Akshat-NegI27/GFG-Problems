class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        traverse(node.left, result);
        traverse(node.right, result);
        result.add(node.data);
    }
}
