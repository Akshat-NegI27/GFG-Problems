class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] first = bfs(0, adj, V);
        int[] second = bfs(first[0], adj, V);
        return second[1];
    }
    
    private int[] bfs(int start, List<List<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        vis[start] = true;
        
        int farNode = start, maxDist = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int u = node[0], d = node[1];
            if (d > maxDist) {
                maxDist = d;
                farNode = u;
            }
            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.offer(new int[]{v, d + 1});
                }
            }
        }
        return new int[]{farNode, maxDist};
    }
}
