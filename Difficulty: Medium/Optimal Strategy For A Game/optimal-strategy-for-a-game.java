class Solution {
    public int maximumAmount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = arr[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                int pickLeft = arr[i] + Math.min(x, y);
                int pickRight = arr[j] + Math.min(y, z);

                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1];
    }
}