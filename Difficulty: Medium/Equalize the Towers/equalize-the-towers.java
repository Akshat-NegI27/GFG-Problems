class Solution {
    
    private int check(int[] heights, int[] cost, int mid) {
        int n = cost.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(heights[i] - mid);
            ans += val * cost[i];
        }
        return ans;
    }

    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        
        // Find min and max in heights
        for (int h : heights) {
            l = Math.min(l, h);
            r = Math.max(r, h);
        }

        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cost1 = check(heights, cost, mid);
            int cost2 = check(heights, cost, mid + 1);

            if (cost1 <= cost2) {
                ans = cost1;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
