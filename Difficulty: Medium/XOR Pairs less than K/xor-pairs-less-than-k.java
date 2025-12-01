class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }

    private void insert(TrieNode root, int num) {
        for (int b = 15; b >= 0; b--) { 
            int bit = (num >> b) & 1;
            if (root.child[bit] == null) root.child[bit] = new TrieNode();
            root = root.child[bit];
            root.count++;
        }
    }

    private int countLess(TrieNode root, int num, int k) {
        int total = 0;
        for (int b = 15; b >= 0; b--) {
            if (root == null) break;

            int nb = (num >> b) & 1;
            int kb = (k >> b) & 1;

            if (kb == 1) {

                if (root.child[nb] != null)
                    total += root.child[nb].count;

                root = root.child[1 - nb];
            } else {

                root = root.child[nb];
            }
        }
        return total;
    }

    public int cntPairs(int[] arr, int k) {
        TrieNode root = new TrieNode();
        int ans = 0;

        for (int x : arr) {
            ans += countLess(root, x, k);
            insert(root, x);
        }
        return ans;
    }
}