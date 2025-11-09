class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        Integer[][][] dp = new Integer[n][n][n];
        int res = dfs(mat, 0, 0, 0, dp, n);
        return Math.max(res, 0);
    }

    private int dfs(int[][] mat, int r1, int c1, int r2, Integer[][][] dp, int n) {
        int c2 = r1 + c1 - r2;

        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            mat[r1][c1] == -1 || mat[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if (r1 == n - 1 && c1 == n - 1)
            return mat[r1][c1];

        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];

        int curr = (r1 == r2 && c1 == c2) ? mat[r1][c1] : mat[r1][c1] + mat[r2][c2];

        int maxNext = Math.max(
            Math.max(dfs(mat, r1 + 1, c1, r2 + 1, dp, n), dfs(mat, r1, c1 + 1, r2, dp, n)),
            Math.max(dfs(mat, r1 + 1, c1, r2, dp, n), dfs(mat, r1, c1 + 1, r2 + 1, dp, n))
        );

        curr += maxNext;
        dp[r1][c1][r2] = curr;
        return curr;
    }
}
