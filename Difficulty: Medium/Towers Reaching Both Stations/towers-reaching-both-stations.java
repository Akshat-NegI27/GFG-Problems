class Solution {
    public int countCoordinates(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        Queue<int[]> pq = new ArrayDeque<>();
        Queue<int[]> qq = new ArrayDeque<>();

        // Station P: top row
        for (int j = 0; j < m; j++) {
            p[0][j] = true;
            pq.offer(new int[]{0, j});
        }

        // Station P: left column
        for (int i = 0; i < n; i++) {
            if (!p[i][0]) {
                p[i][0] = true;
                pq.offer(new int[]{i, 0});
            }
        }

        // Station Q: bottom row
        for (int j = 0; j < m; j++) {
            q[n - 1][j] = true;
            qq.offer(new int[]{n - 1, j});
        }

        // Station Q: right column
        for (int i = 0; i < n; i++) {
            if (!q[i][m - 1]) {
                q[i][m - 1] = true;
                qq.offer(new int[]{i, m - 1});
            }
        }

        bfs(mat, pq, p);
        bfs(mat, qq, q);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j])
                    ans++;
            }
        }

        return ans;
    }

    private void bfs(int[][] mat, Queue<int[]> q, boolean[][] vis) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                if (vis[nr][nc])
                    continue;

                if (mat[nr][nc] >= mat[r][c]) {
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}