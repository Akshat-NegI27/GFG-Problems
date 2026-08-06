class Solution {
    public int countMinOperations(int arr[]) {
        long increments = 0;
        int maxBits = 0;

        for (int x : arr) {
            increments += Integer.bitCount(x);

            int bits = 0;
            int temp = x;
            while (temp > 0) {
                bits++;
                temp >>= 1;
            }
            maxBits = Math.max(maxBits, bits);
        }

        return (int)(increments + Math.max(0, maxBits - 1));
    }
}