class Solution {
    public int numberOfPath(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        Integer[][][] dp = new Integer[n][m][k + 1];
        return dfs(0, 0, k, mat, n, m, dp);
    }

    private int dfs(int i, int j, int k, int[][] mat, int n, int m, Integer[][][] dp) {
        if (i >= n || j >= m) return 0;
        if (k < 0) return 0;
        if (i == n - 1 && j == m - 1)
            return (k == mat[i][j]) ? 1 : 0;
        if (dp[i][j][k] != null) return dp[i][j][k];

        int rem = k - mat[i][j];
        int down = dfs(i + 1, j, rem, mat, n, m, dp);
        int right = dfs(i, j + 1, rem, mat, n, m, dp);

        return dp[i][j][k] = down + right;
    }
}
