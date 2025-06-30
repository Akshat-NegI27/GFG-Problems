class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MAX_VALUE;

        for (int num : arr) {
            low = Math.min(low, num);
        }

        high = low + k;

        int result = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, w, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(int[] arr, int n, int k, int w, int minHeight) {
        long[] water = new long[n + 2];
        long currentWater = 0;
        long totalWaterUsed = 0;

        for (int i = 0; i < n; i++) {
            currentWater += water[i];
            long currentHeight = arr[i] + currentWater;

            if (currentHeight < minHeight) {
                long need = minHeight - currentHeight;
                totalWaterUsed += need;

                if (totalWaterUsed > k) {
                    return false;
                }

                currentWater += need;
                if (i + w < water.length) {
                    water[i + w] -= need;
                }
            }
        }

        return true;
    }
}
