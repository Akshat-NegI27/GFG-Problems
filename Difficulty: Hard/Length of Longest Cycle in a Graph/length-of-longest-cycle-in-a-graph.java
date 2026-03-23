import java.util.*;

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] out = new int[V];
        Arrays.fill(out, -1);

        for (int[] e : edges) {
            out[e[0]] = e[1];
        }

        int[] vis = new int[V];
        int[] dist = new int[V];
        int ans = -1;

        for (int i = 0; i < V; i++) {
            if (vis[i] != 0) continue;

            int node = i;
            int d = 0;
            HashMap<Integer,Integer> map = new HashMap<>();

            while (node != -1 && vis[node] == 0) {
                vis[node] = 1;
                map.put(node, d);
                dist[node] = d++;
                node = out[node];

                if (node != -1 && map.containsKey(node)) {
                    ans = Math.max(ans, d - map.get(node));
                }
            }

            node = i;
            while (node != -1 && vis[node] == 1) {
                vis[node] = 2;
                node = out[node];
            }
        }

        return ans;
    }
}