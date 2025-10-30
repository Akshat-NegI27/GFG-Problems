class Solution {
    public void fill(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') {
                q.add(new int[]{i, 0});
                vis[i][0] = true;
            }
            if (grid[i][m - 1] == 'O') {
                q.add(new int[]{i, m - 1});
                vis[i][m - 1] = true;
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O') {
                q.add(new int[]{0, j});
                vis[0][j] = true;
            }
            if (grid[n - 1][j] == 'O') {
                q.add(new int[]{n - 1, j});
                vis[n - 1][j] = true;
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny] && grid[nx][ny] == 'O') {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O' && !vis[i][j]) grid[i][j] = 'X';
            }
        }
    }
}
