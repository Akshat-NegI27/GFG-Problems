class Solution {
    public int findMedian(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        if (n % 2 == 0) return list.get(n / 2 - 1);
        else return list.get(n / 2);
    }
    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
