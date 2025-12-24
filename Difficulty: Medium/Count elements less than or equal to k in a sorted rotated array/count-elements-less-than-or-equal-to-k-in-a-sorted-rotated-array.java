class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr);

        int count = 0;

        if (pivot > 0)
            count += upperBound(arr, 0, pivot - 1, x);
        count += upperBound(arr, pivot, n - 1, x);

        return count;
    }

    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, int l, int r, int x) {
        int low = l, high = r + 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low - l;
    }
}
