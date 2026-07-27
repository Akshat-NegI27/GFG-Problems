class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;

        long[][] pref = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                        + pref[i - 1][j]
                        + pref[i][j - 1]
                        - pref[i - 1][j - 1];
            }
        }

        long ans = Long.MIN_VALUE;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                long sum = pref[i][j]
                        - pref[i - k][j]
                        - pref[i][j - k]
                        + pref[i - k][j - k];
                ans = Math.max(ans, sum);
            }
        }

        return (int) ans;
    }
}