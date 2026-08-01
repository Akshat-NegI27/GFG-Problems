class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        long[] diff = new long[n + 1];

        for (int i = 0; i < a.length; i++) {
            diff[a[i]] += k[i];
            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }

        long cur = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            ans = Math.max(ans, cur);
        }

        return (int) ans;
    }
}