class Solution {
    int n, m;

    int cntOnes(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        // Traverse boundary cells
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(grid, vis, i, 0);
            }

            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(grid, vis, i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(grid, vis, 0, j);
            }

            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(grid, vis, n - 1, j);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, boolean[][] vis, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m ||
            grid[r][c] == 0 || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        dfs(grid, vis, r + 1, c);
        dfs(grid, vis, r - 1, c);
        dfs(grid, vis, r, c + 1);
        dfs(grid, vis, r, c - 1);
    }
}