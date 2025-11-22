class Solution {
    public int minConnect(int V, int[][] edges) {
        if (edges.length < V - 1) return -1;

        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        for (int[] e : edges) {
            union(e[0], e[1], parent, rank);
        }

        int comp = 0;
        for (int i = 0; i < V; i++) {
            if (find(i, parent) == i) comp++;
        }

        return comp - 1;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private void union(int a, int b, int[] parent, int[] rank) {
        int pa = find(a, parent);
        int pb = find(b, parent);
        if (pa == pb) return;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}
