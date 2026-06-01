class Solution {
    static final long MOD = 1000000007L;

    public int findMaxProduct(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        long product = 1;
        int negCount = 0;
        int zeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x == 0) {
                zeroCount++;
                continue;
            }

            if (x < 0) {
                negCount++;
                maxNegative = Math.max(maxNegative, x);
            }

            product = (product * x) % MOD;
        }

        // All zeros
        if (zeroCount == n) {
            return 0;
        }

        // Only one negative and rest zeros
        if (negCount == 1 && zeroCount + negCount == n) {
            return 0;
        }

        // Odd number of negatives: remove the negative
        // closest to zero.
        if ((negCount & 1) == 1) {
            product = product * modInverse(maxNegative) % MOD;
        }

        if (product < 0) {
            product += MOD;
        }

        return (int) product;
    }

    long modPow(long a, long b) {
        a = ((a % MOD) + MOD) % MOD;
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}