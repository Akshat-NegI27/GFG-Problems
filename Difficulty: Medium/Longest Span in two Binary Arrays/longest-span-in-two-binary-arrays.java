
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        int n = a1.length;
        int[] diff = new int[n];

        // Create difference array
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }

        // Map to store prefix sum and its first occurrence
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];

            if (sum == 0) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
