class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;

        int[] dp = new int[n];

        // First row
        for (int j = 0; j < n; j++) {
            dp[j] = mat[0][j];
        }

        // Remaining rows
        for (int i = 1; i < n; i++) {
            int[] next = new int[n];

            for (int j = 0; j < n; j++) {
                int best = 0;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        best = Math.max(best, dp[k]);
                    }
                }

                next[j] = mat[i][j] + best;
            }

            dp = next;
        }

        int ans = 0;

        for (int value : dp) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}