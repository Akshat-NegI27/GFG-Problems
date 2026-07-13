class Solution {
    static final int MOD = 1_000_000_007;

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];

        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) spf[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        HashMap<Integer, Integer> maxPow = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            int len = 0;
            int cur = i;
            while (!vis[cur]) {
                vis[cur] = true;
                cur = b[cur] - 1;
                len++;
            }

            int x = len;
            while (x > 1) {
                int p = spf[x];
                int cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                maxPow.put(p, Math.max(maxPow.getOrDefault(p, 0), cnt));
            }
        }

        long ans = 1;
        for (var e : maxPow.entrySet()) {
            int p = e.getKey();
            int cnt = e.getValue();
            while (cnt-- > 0) {
                ans = (ans * p) % MOD;
            }
        }

        return (int) ans;
    }
}