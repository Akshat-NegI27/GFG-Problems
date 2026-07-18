class Solution {
    static final int MOD = 1_000_000_007;

    public int findWays(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;

        // Suffix sum of 1's
        int[][] pre = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                pre[i][j] = matrix[i][j] + pre[i + 1][j] + pre[i][j + 1] - pre[i + 1][j + 1];
            }
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = pre[i][j] > 0 ? 1 : 0;
            }
        }

        for (int cut = 1; cut < k; cut++) {

            int[][] row = new int[n + 1][m];
            int[][] col = new int[n][m + 1];

            // suffix sums of previous dp
            for (int j = 0; j < m; j++) {
                for (int i = n - 1; i >= 0; i--) {
                    row[i][j] = (dp[i][j] + row[i + 1][j]) % MOD;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j >= 0; j--) {
                    col[i][j] = (dp[i][j] + col[i][j + 1]) % MOD;
                }
            }

            int[][] ndp = new int[n][m];

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {

                    long ways = 0;

                    // first valid horizontal cut
                    for (int r = i + 1; r < n; r++) {
                        if (pre[i][j] > pre[r][j]) {
                            ways += row[r][j];
                            break;
                        }
                    }

                    // first valid vertical cut
                    for (int c = j + 1; c < m; c++) {
                        if (pre[i][j] > pre[i][c]) {
                            ways += col[i][c];
                            break;
                        }
                    }

                    ndp[i][j] = (int) (ways % MOD);
                }
            }

            dp = ndp;
        }

        return dp[0][0];
    }
}