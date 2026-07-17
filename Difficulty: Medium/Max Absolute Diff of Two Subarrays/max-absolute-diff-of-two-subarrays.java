class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n = arr.length;

        int[] leftMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        int[] rightMin = new int[n];

        int maxEnd = arr[0], minEnd = arr[0];
        leftMax[0] = arr[0];
        leftMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            leftMax[i] = Math.max(leftMax[i - 1], maxEnd);

            minEnd = Math.min(arr[i], minEnd + arr[i]);
            leftMin[i] = Math.min(leftMin[i - 1], minEnd);
        }

        maxEnd = arr[n - 1];
        minEnd = arr[n - 1];
        rightMax[n - 1] = arr[n - 1];
        rightMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            rightMax[i] = Math.max(rightMax[i + 1], maxEnd);

            minEnd = Math.min(arr[i], minEnd + arr[i]);
            rightMin[i] = Math.min(rightMin[i + 1], minEnd);
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, Math.abs(leftMax[i] - rightMin[i + 1]));
            ans = Math.max(ans, Math.abs(leftMin[i] - rightMax[i + 1]));
        }

        return ans;
    }
}