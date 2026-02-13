class Solution {

    public int getCount(int n, int d) {
        long left = 1, right = n;
        long firstValid = n + 1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid - digitSum(mid) >= d) {
                firstValid = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (firstValid > n) return 0;
        return (int)(n - firstValid + 1);
    }

    private long digitSum(long x) {
        long sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
