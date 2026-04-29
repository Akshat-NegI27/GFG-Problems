class Solution {
    public int minSwaps(int[] arr) {
        int ones = 0;
        for (int x : arr) {
            if (x == 1) ones++;
        }

        if (ones == 0) return -1;
        if (ones == 1) return 0;

        int zeros = 0;
        for (int i = 0; i < ones; i++) {
            if (arr[i] == 0) zeros++;
        }

        int minSwaps = zeros;

        for (int i = ones; i < arr.length; i++) {
            if (arr[i - ones] == 0) zeros--;
            if (arr[i] == 0) zeros++;
            minSwaps = Math.min(minSwaps, zeros);
        }

        return minSwaps;
    }
}