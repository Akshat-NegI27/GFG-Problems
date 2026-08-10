class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;

        if (n == 1) {
            return Math.max(h[0], l[0]);
        }

        int prev2 = 0;
        int prev1 = Math.max(h[0], l[0]);

        for (int i = 1; i < n; i++) {
            int high = h[i] + prev2;
            int low = l[i] + prev1;

            int curr = Math.max(high, low);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}