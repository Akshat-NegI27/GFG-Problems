class Solution {
    public int binarySearchable(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int l = 0;
            int r = n - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (x == arr[mid]) {
                    count++;
                    break;
                }

                if (arr[mid] > x) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return count;
    }
}