class Solution {
    static final int MOD = 1000000007;

    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : arr) {
            pq.offer(x);
        }

        long ans = 0;

        while (k-- > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            ans = (ans + cur) % MOD;

            if (cur > 1) {
                pq.offer(cur - 1);
            }
        }

        return (int) ans;
    }
}