class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        int size = 2 * n + 5;
        Fenwick bit = new Fenwick(size);

        int offset = n + 2;
        int prefix = 0;
        long ans = 0;

        // Initial prefix sum = 0
        bit.update(offset, 1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                prefix++;
            else
                prefix--;

            int idx = prefix + offset;

            // Count previous prefix sums strictly smaller than current
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return (int) ans;
    }

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}