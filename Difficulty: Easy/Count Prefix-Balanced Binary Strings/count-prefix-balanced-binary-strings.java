class Solution {

    static final long MOD = 1000000007L;

    public int prefixStrings(int n) {

        long[] fact = new long[2 * n + 1];

        fact[0] = 1;

        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // C(2n, n) = (2n)! / (n! * n!)
        long numerator = fact[2 * n];

        long denominator = (fact[n] * fact[n]) % MOD;

        long combination = numerator * modInverse(denominator) % MOD;

        // Catalan = C(2n,n) / (n+1)
        long answer = combination * modInverse(n + 1) % MOD;

        return (int) answer;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {

        long result = 1;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}