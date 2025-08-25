class Solution {
    private boolean isPossible(int[] arr, int k, int mid) {
        int students = 1;
        int sum = 0;
        for (int pages : arr) {
            if (pages > mid) return false;
            if (sum + pages > mid) {
                students++;
                sum = pages;
                if (students > k) return false;
            } else {
                sum += pages;
            }
        }
        return true;
    }

    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;

        int low = 0, high = 0, ans = -1;
        for (int pages : arr) {
            high += pages;
            low = Math.max(low, pages);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
