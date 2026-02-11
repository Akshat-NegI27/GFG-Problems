class Solution {

    private long getCost(int[] heights, int[] cost, int target) {
        long totalCost = 0;

        for (int i = 0; i < heights.length; i++) {
            totalCost += 1L * Math.abs(heights[i] - target) * cost[i];
        }

        return totalCost;
    }

    public int minCost(int[] heights, int[] cost) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int h : heights) {
            left = Math.min(left, h);
            right = Math.max(right, h);
        }

        long answer = Long.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long cost1 = getCost(heights, cost, mid);
            long cost2 = getCost(heights, cost, mid + 1);

            answer = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) answer;
    }
}