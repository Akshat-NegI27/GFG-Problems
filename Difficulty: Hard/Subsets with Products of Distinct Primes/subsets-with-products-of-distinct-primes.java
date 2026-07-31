class Solution {
    static final int MOD = 1_000_000_007;
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public int countSubsets(int[] arr) {
        int[] freq = new int[31];
        for (int x : arr) freq[x]++;

        int[] masks = new int[31];
        for (int i = 2; i <= 30; i++) masks[i] = getMask(i);

        long[] dp = new long[1 << 10];
        dp[0] = 1;

        for (int v = 2; v <= 30; v++) {
            if (freq[v] == 0 || masks[v] == -1) continue;

            int mask = masks[v];
            long[] ndp = dp.clone();

            for (int s = 0; s < (1 << 10); s++) {
                if ((s & mask) == 0) {
                    int ns = s | mask;
                    ndp[ns] = (ndp[ns] + dp[s] * freq[v]) % MOD;
                }
            }
            dp = ndp;
        }

        long ans = 0;
        for (int s = 1; s < (1 << 10); s++) {
            ans = (ans + dp[s]) % MOD;
        }

        long mul = 1;
        for (int i = 0; i < freq[1]; i++) {
            mul = (mul * 2) % MOD;
        }

        ans = (ans * mul) % MOD;
        return (int) ans;
    }

    private int getMask(int x) {
        int mask = 0;
        for (int i = 0; i < PRIMES.length; i++) {
            int p = PRIMES[i];
            if (x % (p * p) == 0) return -1;
            if (x % p == 0) mask |= 1 << i;
        }
        return mask;
    }
}