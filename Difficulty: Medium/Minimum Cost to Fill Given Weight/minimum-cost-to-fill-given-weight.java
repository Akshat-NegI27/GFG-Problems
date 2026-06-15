class Solution {
    public int minimumCost(int[] cost, int w) {
        int INF = Integer.MAX_VALUE / 2;

        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] == -1) continue;

            int weight = i + 1;
            int price = cost[i];

            for (int j = weight; j <= w; j++) {
                dp[j] = Math.min(dp[j], dp[j - weight] + price);
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}