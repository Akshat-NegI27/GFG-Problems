class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        int extra = 0;
        for (int[] e : edges) {
            if (e[2] == 2) extra++;
        }

        int total = V + extra;
        ArrayList<Integer>[] graph = new ArrayList[total];
        for (int i = 0; i < total; i++) {
            graph[i] = new ArrayList<>();
        }

        int dummy = V;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (w == 1) {
                graph[u].add(v);
                graph[v].add(u);
            } else {
                graph[u].add(dummy);
                graph[dummy].add(u);

                graph[dummy].add(v);
                graph[v].add(dummy);

                dummy++;
            }
        }

        int[] dist = new int[total];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            if (u == dest) return dist[u];

            for (int v : graph[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        return -1;
    }
}