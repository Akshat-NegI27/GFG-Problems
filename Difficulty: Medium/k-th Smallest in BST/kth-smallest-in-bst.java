class Solution {
    int count = 0, ans = -1;
    public int kthSmallest(Node root, int k) {
        inorder(root, k);
        return ans;
    }
    private void inorder(Node root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        inorder(root.right, k);
    }
}
