class Solution {
    int maxRemove(int[][] stones) {
        int n = stones.length;

        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        int idx = 0;

        for (int[] s : stones) {
            if (!map.containsKey(s[0])) map.put(s[0], idx++);
            if (!map.containsKey(~s[1])) map.put(~s[1], idx++);
        }

        int[] parent = new int[idx];
        int[] rank = new int[idx];
        for (int i = 0; i < idx; i++) parent[i] = i;

        for (int[] s : stones) {
            int r = map.get(s[0]);
            int c = map.get(~s[1]);
            union(r, c, parent, rank);
        }

        java.util.Set<Integer> comps = new java.util.HashSet<>();
        for (int[] s : stones) {
            comps.add(find(map.get(s[0]), parent));
        }

        return n - comps.size();
    }

    int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    void union(int a, int b, int[] parent, int[] rank) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if (pa == pb) return;
        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
