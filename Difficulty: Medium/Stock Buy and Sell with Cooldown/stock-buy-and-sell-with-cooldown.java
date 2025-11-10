class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int buy = -arr[0];  
        int sell = 0;       
        int cool = 0;       

        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            buy = Math.max(buy, cool - arr[i]);
            cool = Math.max(cool, sell);
            sell = prevBuy + arr[i];
        }

        return Math.max(sell, cool);
    }
}