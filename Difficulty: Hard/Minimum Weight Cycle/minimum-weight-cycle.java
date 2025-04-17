//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    public int findMinCycle(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int minCycle = Integer.MAX_VALUE;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Temporarily remove edge (u, v)
            removeEdge(graph, u, v, w);

            int shortest = dijkstra(u, v, graph, V);
            if (shortest != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, shortest + w);
            }

            // Re-add edge
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }

    private void removeEdge(List<List<int[]>> graph, int u, int v, int w) {
        graph.get(u).removeIf(neigh -> neigh[0] == v && neigh[1] == w);
        graph.get(v).removeIf(neigh -> neigh[0] == u && neigh[1] == w);
    }

    private int dijkstra(int src, int dest, List<List<int[]>> graph, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (node == dest) return d;

            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0], weight = neighbor[1];
                if (dist[next] > d + weight) {
                    dist[next] = d + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
