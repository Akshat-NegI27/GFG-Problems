class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            long cnt = (long)(i + 1) * (n - i);
            if ((cnt & 1L) == 1L) res ^= arr[i];
        }
        return res;
    }
}
