class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#') {
            return 0;
        }

        // Minimum number of upward moves required to reach each cell
        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();

        dist[r][c] = 0;
        dq.offerFirst(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();

            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dr[i];
                int ny = y + dc[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (mat[nx][ny] == '#') {
                    continue;
                }

                // Moving up costs 1, everything else costs 0
                int cost = (nx < x) ? 1 : 0;

                if (dist[x][y] + cost < dist[nx][ny]) {

                    dist[nx][ny] = dist[x][y] + cost;

                    if (cost == 0) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == '#') {
                    continue;
                }

                if (dist[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int up = dist[i][j];

                // down - up = i - r
                int down = up + (i - r);

                if (up <= u && down <= d) {
                    answer++;
                }
            }
        }

        return answer;
    }
}