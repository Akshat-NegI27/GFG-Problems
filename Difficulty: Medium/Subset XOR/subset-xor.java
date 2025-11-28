class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        int X = xorToN(n);
        if (X == n) {
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        int k = X ^ n;

        for (int i = 1; i <= n; i++) {
            if (i != k) ans.add(i);
        }
        return ans;
    }

    static int xorToN(int n) {
        int r = n & 3;
        if (r == 0) return n;
        if (r == 1) return 1;
        if (r == 2) return n + 1;
        return 0;
    }
}
