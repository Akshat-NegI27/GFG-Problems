class Solution {

    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;

        long low = Integer.MAX_VALUE;
        long high = low + k;

        for (int x : arr) low = Math.min(low, x);

        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (canMake(arr, k, w, mid))
                low = mid;
            else
                high = mid - 1;
        }

        return (int) low;
    }

    private boolean canMake(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long currAdd = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            long height = arr[i] + currAdd;

            if (height < target) {
                long need = target - height;
                used += need;
                if (used > k) return false;

                currAdd += need;
                if (i + w < diff.length)
                    diff[i + w] -= need;
            }
        }

        return true;
    }
}
