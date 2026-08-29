class Solution {
    public int countSubsequences(String s, int n) {

        final long MOD = 1000000007L;

        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            // Copy old values because we must not use
            // the current digit more than once.
            long[] next = dp.clone();

            // Start a new subsequence with this digit
            int rem = digit % n;
            next[rem] = (next[rem] + 1) % MOD;

            // Append current digit to every existing subsequence
            for (int r = 0; r < n; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRem = (r * 10 + digit) % n;

                next[newRem] =
                    (next[newRem] + dp[r]) % MOD;
            }

            dp = next;
        }

        return (int) dp[0];
    }
}