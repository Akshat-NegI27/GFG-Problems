class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            diff += a1[i] - a2[i];

            if (map.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }

        return maxLen;
    }
}