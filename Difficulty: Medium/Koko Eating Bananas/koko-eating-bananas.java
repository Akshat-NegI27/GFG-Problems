class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;
        for (int bananas : arr) {
            high = Math.max(high, bananas); // max of array
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(arr, k, mid)) {
                result = mid;
                high = mid - 1; // try to find a smaller s
            } else {
                low = mid + 1; // increase s
            }
        }

        return result;
    }

    private boolean canFinish(int[] arr, int k, int s) {
        int totalHours = 0;
        for (int bananas : arr) {
            totalHours += (bananas + s - 1) / s; // ceil(bananas/s)
        }
        return totalHours <= k;
    }
}
