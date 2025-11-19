class Solution {
    public int minCostPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0], x = cur[1], y = cur[2];
            if (x == n - 1 && y == m - 1) return effort;
            if (effort > dist[x][y]) continue;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int cost = Math.max(effort, Math.abs(mat[x][y] - mat[nx][ny]));
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        pq.add(new int[]{cost, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}