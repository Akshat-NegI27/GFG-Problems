class Solution {
    public int median(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 1, high = 2000; 

        int desired = (n * m + 1) / 2; 

        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                count += countSmallerThanOrEqual(mat[i], mid);
            }

            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countSmallerThanOrEqual(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}