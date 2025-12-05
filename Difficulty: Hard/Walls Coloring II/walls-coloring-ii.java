class Solution {
    int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return -1;

        if (k == 1) return n == 1 ? costs[0][0] : -1;

        int[] dp = new int[k];
        int[] newDp = new int[k];

        for (int j = 0; j < k; j++) dp[j] = costs[0][j];

        for (int i = 1; i < n; i++) {

            int min1 = -1, min2 = -1;

            for (int j = 0; j < k; j++) {
                if (min1 == -1 || dp[j] < dp[min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || dp[j] < dp[min2]) {
                    min2 = j;
                }
            }

            for (int j = 0; j < k; j++) {
                if (j == min1) newDp[j] = dp[min2] + costs[i][j];
                else newDp[j] = dp[min1] + costs[i][j];
            }

            int[] temp = dp;
            dp = newDp;
            newDp = temp;
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) ans = Math.min(ans, dp[j]);

        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}
