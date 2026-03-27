class Solution {
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, m - 1, grid, dp);
    }

    int solve(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return -1000000;

        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = 0;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value;
                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += solve(i + 1, j1 + d1, j2 + d2, grid, dp);
                max = Math.max(max, value);
            }
        }

        return dp[i][j1][j2] = max;
    }
}