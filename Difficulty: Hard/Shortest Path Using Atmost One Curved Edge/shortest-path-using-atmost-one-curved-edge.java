import java.util.*;

class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());

        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }

        int[] distA = dijkstra(a, g, V);
        int[] distB = dijkstra(b, g, V);

        int ans = distA[b];

        for (int[] e : edges) {
            int x = e[0], y = e[1], w2 = e[3];

            if (distA[x] != Integer.MAX_VALUE && distB[y] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[x] + w2 + distB[y]);

            if (distA[y] != Integer.MAX_VALUE && distB[x] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[y] + w2 + distB[x]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int[] dijkstra(int src, List<List<int[]>> g, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u]) continue;

            for (int[] nxt : g.get(u)) {
                int v = nxt[0], w = nxt[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}
