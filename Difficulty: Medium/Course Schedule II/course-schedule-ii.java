class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) 
            if (indegree[i] == 0) q.add(i);

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int course = q.poll();
            order.add(course);
            for (int next : adj.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }

        if (order.size() != n) return new ArrayList<>();
        return order;
    }
}