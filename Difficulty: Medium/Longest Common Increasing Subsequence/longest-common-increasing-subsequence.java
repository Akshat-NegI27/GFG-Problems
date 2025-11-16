class Solution {
    public int LCIS(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[j] = currentMax + 1;
                    ans = Math.max(ans, dp[j]);
                } else if (a[i] > b[j]) {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }
        }

        return ans;
    }
}
