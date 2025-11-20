class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        int n = s.length();
        int INF = (int)1e9;

        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < transform.length; i++) {
            int a = transform[i][0] - 'a';
            int b = transform[i][1] - 'a';
            dist[a][b] = Math.min(dist[a][b], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (a == b) continue;

            int x = a - 'a', y = b - 'a';
            int best = INF;

            for (int c = 0; c < 26; c++) {
                if (dist[x][c] < INF && dist[y][c] < INF) {
                    best = Math.min(best, dist[x][c] + dist[y][c]);
                }
            }

            if (best == INF) return -1;

            ans += best;
        }

        return (int)ans;
    }
}
