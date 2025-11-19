class Solution {
    static final int MOD = 1000000007;

    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        long[] ways = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];
            if (d > dist[u]) continue;

            for (int[] nxt : adj.get(u)) {
                int v = nxt[0];
                long w = nxt[1];

                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    ways[v] = ways[u];
                    pq.add(new long[]{v, dist[v]});
                } else if (dist[v] == d + w) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[V - 1];
    }
}
