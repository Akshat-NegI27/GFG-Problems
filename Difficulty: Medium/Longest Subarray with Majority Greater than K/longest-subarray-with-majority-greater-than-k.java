class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        int prefix = 0;
        int ans = 0;

        HashMap<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > k) prefix += 1;
            else prefix -= 1;

            if (prefix > 0) {
                ans = i + 1;
            } else {
                if (firstIndex.containsKey(prefix - 1)) {
                    ans = Math.max(ans, i - firstIndex.get(prefix - 1));
                }
            }

            firstIndex.putIfAbsent(prefix, i);
        }

        return ans;
    }
}