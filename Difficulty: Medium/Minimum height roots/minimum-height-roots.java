class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        if (V == 1) {
            res.add(0);
            return res;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        int[] degree = new int[V];

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) q.add(i);
        }

        int remaining = V;

        while (remaining > 2) {
            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {
                int leaf = q.poll();

                for (int nei : adj.get(leaf)) {
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        q.add(nei);
                    }
                }
            }
        }

        res.addAll(q);
        return res;
    }
}