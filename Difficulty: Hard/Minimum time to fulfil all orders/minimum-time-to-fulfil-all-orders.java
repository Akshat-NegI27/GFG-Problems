class Solution {
    public int minTime(int[] ranks, int n) {
        int low = 0;
        int maxRank = 0;

        for (int r : ranks)
            maxRank = Math.max(maxRank, r);

        int high = maxRank * n * (n + 1) / 2;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] ranks, int n, int time) {
        int donuts = 0;

        for (int r : ranks) {
            int t = 0;
            int k = 1;

            while (true) {
                t += r * k;
                if (t > time)
                    break;
                donuts++;
                k++;

                if (donuts >= n)
                    return true;
            }
        }
        return donuts >= n;
    }
}
