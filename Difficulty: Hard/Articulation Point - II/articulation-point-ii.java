//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.articulationPoints(V, edges);
            Collections.sort(ans);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] time = {0};
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isArticulation = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfs(i, -1, time, disc, low, visited, isArticulation, adj);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) if (isArticulation[i]) res.add(i);
        if (res.size() == 0) res.add(-1);
        return res;
    }

    static void dfs(int u, int parent, int[] time, int[] disc, int[] low, boolean[] visited, boolean[] isArticulation, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true;
        disc[u] = low[u] = ++time[0];
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, u, time, disc, low, visited, isArticulation, adj);
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= disc[u]) isArticulation[u] = true;
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1) isArticulation[u] = true;
    }
}
