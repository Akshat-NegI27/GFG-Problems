class Solution {
    public long sumXOR(int[] arr) {
        long ans = 0;
        int n = arr.length;

        for (int bit = 0; bit < 32; bit++) {
            long countSet = 0;

            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    countSet++;
                }
            }

            long countUnset = n - countSet;
            ans += countSet * countUnset * (1L << bit);
        }

        return ans;
    }
}