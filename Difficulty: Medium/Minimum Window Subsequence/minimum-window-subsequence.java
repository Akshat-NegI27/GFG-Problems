class Solution {
    static final int INF = (int)1e9;

    int solve(int i, int j, String s1, String s2, int[][] dp) {
        if (j >= s2.length()) return 0;
        if (i >= s1.length()) return INF;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = INF;

        if (s1.charAt(i) == s2.charAt(j)) {
            int take = solve(i + 1, j + 1, s1, s2, dp);
            int notake = solve(i + 1, j, s1, s2, dp);

            if (take != INF) take += 1;
            if (notake != INF) notake += 1;

            ans = Math.min(take, notake);
        } else {
            int temp = solve(i + 1, j, s1, s2, dp);
            if (temp != INF) ans = 1 + temp;
        }

        return dp[i][j] = ans;
    }

    public String minWindow(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int start = -1, len = INF;

        int[][] dp = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) dp[i][j] = -1;
        }

        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                int curr = solve(i, 0, s1, s2, dp);
                if (curr < len) {
                    len = curr;
                    start = i;
                }
            }
        }

        return start == -1 ? "" : s1.substring(start, start + len);
    }
}
