class Solution {
    public int countWays(int n, int sum) {
        if (sum == 0 || sum > 9 * n) return -1;

        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int d = 1; d <= 9 && d <= sum; d++) {
            dp[1][d] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                for (int d = 0; d <= 9; d++) {
                    if (s >= d) {
                        dp[i][s] += dp[i - 1][s - d];
                    }
                }
            }
        }

        return dp[n][sum] == 0 ? -1 : dp[n][sum];
    }
}