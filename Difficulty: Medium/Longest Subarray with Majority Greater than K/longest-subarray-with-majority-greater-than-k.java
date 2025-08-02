class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = arr[i] > k ? 1 : -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];

            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(prefixSum - 1));
                }
            }
            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}
