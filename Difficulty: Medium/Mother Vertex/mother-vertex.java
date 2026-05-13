import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                candidate = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(candidate, adj, visited);

        for (boolean v : visited) {
            if (!v) return -1;
        }

        for (int i = 0; i < candidate; i++) {
            Arrays.fill(visited, false);
            dfs(i, adj, visited);

            boolean ok = true;

            for (boolean v : visited) {
                if (!v) {
                    ok = false;
                    break;
                }
            }

            if (ok) return i;
        }

        return candidate;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }
}