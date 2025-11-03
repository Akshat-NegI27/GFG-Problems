class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            revAdj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (adj.get(i).isEmpty())
                q.add(i);

        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;
            for (int prev : revAdj.get(node)) {
                indegree[prev]--;
                if (indegree[prev] == 0)
                    q.add(prev);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++)
            if (safe[i])
                ans.add(i);
        Collections.sort(ans);
        return ans;
    }
}