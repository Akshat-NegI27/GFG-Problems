class Solution {
    public static int countSetBits(int n) {
        return countBits(n);
    }

    private static int countBits(int n) {
        if (n == 0) return 0;

        int x = largestPowerOf2(n);

        int bitsTill2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int rest = countBits(n - (1 << x));

        return bitsTill2x + msbBits + rest;
    }

    private static int largestPowerOf2(int n) {
        int x = 0;
        while ((1 << (x + 1)) <= n)
            x++;
        return x;
    }
}