class Solution {
    static final int MAX = 10001;

    int cntCoprime(int[] arr) {
        int[] freq = new int[MAX];
        for (int val : arr) freq[val]++;

        int[] countMultiples = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                countMultiples[i] += freq[j];
            }
        }

        int[] mu = mobius(MAX);
        long res = 0;
        for (int i = 1; i < MAX; i++) {
            int cnt = countMultiples[i];
            long pairs = (1L * cnt * (cnt - 1)) / 2;
            res += mu[i] * pairs;
        }

        return (int) res;
    }

    int[] mobius(int n) {
        int[] mu = new int[n];
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            mu[i] = 1;
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i; j < n; j += i) {
                    mu[j] *= -1;
                    isPrime[j] = false;
                }
                long sq = 1L * i * i;
                for (int j = (int) sq; j < n; j += sq) {
                    mu[j] = 0;
                }
            }
        }
        return mu;
    }
}
