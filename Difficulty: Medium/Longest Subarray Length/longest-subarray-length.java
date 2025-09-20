import java.util.*;

class Solution {
    public static int longestSubarray(int[] arr) {
        int n = arr.length;

        int[] v = new int[n];
        for (int i = 0; i < n; ++i) v[i] = (arr[i] <= n) ? arr[i] : n + 1;

        ArrayList<Integer>[] buckets = new ArrayList[n + 2];
        for (int i = 0; i <= n + 1; ++i) buckets[i] = new ArrayList<>();
        for (int i = 0; i < n; ++i) if (v[i] <= n) buckets[v[i]].add(i);

        int[] parent = new int[n];
        int[] size = new int[n];
        boolean[] active = new boolean[n];
        Arrays.fill(parent, -1); 

        class DSU {
            int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            void union(int a, int b) {
                int ra = find(a), rb = find(b);
                if (ra == rb) return;
                if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
                parent[rb] = ra;
                size[ra] += size[rb];
            }
        }
        DSU dsu = new DSU();

        int ans = 0;
        int curMax = 0; 

        for (int L = 1; L <= n; ++L) {
            for (int idx : buckets[L]) {
                active[idx] = true;
                parent[idx] = idx;
                size[idx] = 1;

                if (idx - 1 >= 0 && active[idx - 1]) dsu.union(idx, idx - 1);
                if (idx + 1 < n && active[idx + 1]) dsu.union(idx, idx + 1);
                int root = dsu.find(idx);
                if (size[root] > curMax) curMax = size[root];
            }
            if (curMax >= L) ans = L; 
        }

        return ans;
    }
}