import java.util.*;

class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long minRemoved = Long.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int low = arr[i];
            int high = low + k;

            int idx = upperBound(arr, high);
            long removeLeft = prefix[i];  
            long removeRight = (prefix[n] - prefix[idx]) - (long)(n - idx) * high;

            long totalRemoved = removeLeft + removeRight;
            minRemoved = Math.min(minRemoved, totalRemoved);
        }

        return (int)minRemoved;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
