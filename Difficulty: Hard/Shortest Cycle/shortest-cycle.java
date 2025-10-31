class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{start, -1});
            dist[start] = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int node = cur[0], parent = cur[1];
                for (int nbr : adj.get(node)) {
                    if (dist[nbr] == -1) {
                        dist[nbr] = dist[node] + 1;
                        q.add(new int[]{nbr, node});
                    } else if (nbr != parent) {
                        ans = Math.min(ans, dist[node] + dist[nbr] + 1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}