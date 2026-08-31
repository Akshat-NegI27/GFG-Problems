class Solution {
    public int minCost(int n, int i, int d, int c) {

        long[] dp = new long[n + 1];

        // dp[0] = cost of empty string
        dp[0] = 0;

        for (int len = 1; len <= n; len++) {

            // Option 1: insert one character
            dp[len] = dp[len - 1] + i;

            if (len % 2 == 0) {
                // Option 2: reach len/2, then copy-paste
                dp[len] = Math.min(
                    dp[len],
                    dp[len / 2] + c
                );
            } else {
                // Option 3:
                // reach len/2, copy-paste -> len-1,
                // then insert one character
                dp[len] = Math.min(
                    dp[len],
                    dp[len / 2] + c + i
                );

                // Option 4:
                // reach len/2, copy-paste -> len+1,
                // then delete one character
                dp[len] = Math.min(
                    dp[len],
                    dp[(len + 1) / 2] + c + d
                );
            }
        }

        return (int) dp[n];
    }
}