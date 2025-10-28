class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1], d = cell[2];
            dist[x][y] = d;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny, d + 1});
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) row.add(dist[i][j]);
            ans.add(row);
        }
        
        return ans;
    }
}
