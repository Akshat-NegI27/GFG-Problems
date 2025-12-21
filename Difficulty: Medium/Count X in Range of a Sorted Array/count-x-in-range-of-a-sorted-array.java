class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];

            int left = lowerBound(arr, x);
            int right = upperBound(arr, x);

            int count = Math.max(0, Math.min(right, r + 1) - Math.max(left, l));
            result.add(count);
        }

        return result;
    }

    private int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
