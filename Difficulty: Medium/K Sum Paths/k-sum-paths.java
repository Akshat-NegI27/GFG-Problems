class Solution {
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0L, k, map);
    }

    int dfs(Node node, long sum, int k, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        sum += node.data;

        int count = map.getOrDefault(sum - k, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += dfs(node.left, sum, k, map);
        count += dfs(node.right, sum, k, map);

        map.put(sum, map.get(sum) - 1);

        return count;
    }
}