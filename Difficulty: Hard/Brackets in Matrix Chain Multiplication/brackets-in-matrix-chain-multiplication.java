class Solution {
    static String matrixChainOrder(int arr[]) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        int[][] split = new int[n][n];

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        getBracketString(1, n - 1, split, result);

        return result.toString();
    }

    private static void getBracketString(int i, int j, int[][] split, StringBuilder result) {
        if (i == j) {
            result.append((char)('A' + i - 1));
            return;
        }

        result.append('(');

        int k = split[i][j];

        getBracketString(i, k, split, result);
        getBracketString(k + 1, j, split, result);

        result.append(')');
    }
}