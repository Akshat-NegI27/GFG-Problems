class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int N = 1 << n;
        final int INF = (int)1e9;

        int[][] dp = new int[N][n];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = INF;
            }
        }

        dp[1][0] = 0;

        for (int mask = 0; mask < N; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) continue;
                if (dp[mask][i] == INF) continue;

                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << j)) != 0) continue;
                    int newMask = mask | (1 << j);
                    dp[newMask][j] = Math.min(dp[newMask][j], dp[mask][i] + cost[i][j]);
                }
            }
        }

        int ans = INF;
        int full = (1 << n) - 1;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[full][i] + cost[i][0]);
        }

        return ans;
    }
}