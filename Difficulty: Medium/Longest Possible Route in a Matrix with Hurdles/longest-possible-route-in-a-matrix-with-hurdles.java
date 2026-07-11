class Solution {
    int ans;
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        n = mat.length;
        m = mat[0].length;
        ans = -1;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];
        dfs(mat, xs, ys, xd, yd, vis, 0);

        return ans;
    }

    private void dfs(int[][] mat, int x, int y, int xd, int yd,
                     boolean[][] vis, int len) {

        if (x == xd && y == yd) {
            ans = Math.max(ans, len);
            return;
        }

        vis[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dr[k];
            int ny = y + dc[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && mat[nx][ny] == 1 && !vis[nx][ny]) {
                dfs(mat, nx, ny, xd, yd, vis, len + 1);
            }
        }

        vis[x][y] = false;
    }
}