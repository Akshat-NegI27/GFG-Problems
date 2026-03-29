class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int x : arr) totalSum += x;

        if ((totalSum + diff) % 2 != 0 || totalSum < diff) {
            return 0;
        }

        int target = (totalSum + diff) / 2;
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}