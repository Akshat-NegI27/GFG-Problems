class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        long need = (long) m * k;
        if (need > n) return -1;  

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int x : arr) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int day, int k, int m) {
        int count = 0, bouquets = 0;
        for (int x : arr) {
            if (x <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0; 
            }
        }
        return bouquets >= m;
    }
}
