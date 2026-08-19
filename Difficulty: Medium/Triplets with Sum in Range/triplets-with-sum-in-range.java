class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        java.util.Arrays.sort(arr);

        long ans = countAtMost(arr, r) - countAtMost(arr, l - 1);

        return (int) ans;
    }

    private long countAtMost(int[] arr, int x) {
        int n = arr.length;
        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= x) {
                    // Every index from left to right forms a valid triplet
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}