class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        int[][] intervals = new int[n][2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int l = Math.max(0, i - arr[i]);
                int r = Math.min(n - 1, i + arr[i]);
                intervals[idx][0] = l;
                intervals[idx][1] = r;
                idx++;
            }
        }

        if (idx == 0) return -1;

        Arrays.sort(intervals, 0, idx, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int covered = 0;
        int i = 0;
        int ans = 0;

        while (covered < n) {
            int farthest = covered;
            while (i < idx && intervals[i][0] <= covered) {
                farthest = Math.max(farthest, intervals[i][1] + 1);
                i++;
            }
            if (farthest == covered) return -1;
            ans++;
            covered = farthest;
        }

        return ans;
    }
}