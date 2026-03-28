class Solution {
    static int timer;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] mark = new boolean[V];

        timer = 0;

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, -1, vis, tin, low, adj, mark);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(mark[i]) res.add(i);
        }

        if(res.size() == 0){
            res.add(-1);
        }

        return res;
    }

    static void dfs(int node, int parent, boolean[] vis, int[] tin, int[] low,
                    ArrayList<ArrayList<Integer>> adj, boolean[] mark){

        vis[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;

        for(int nei : adj.get(node)){
            if(nei == parent) continue;

            if(!vis[nei]){
                dfs(nei, node, vis, tin, low, adj, mark);
                low[node] = Math.min(low[node], low[nei]);

                if(low[nei] >= tin[node] && parent != -1){
                    mark[node] = true;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node], tin[nei]);
            }
        }

        if(parent == -1 && child > 1){
            mark[node] = true;
        }
    }
}