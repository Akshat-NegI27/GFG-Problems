class Solution {
    public static int overlapInt(int[][] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : arr) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int curr = 0, maxOverlap = 0;

        for (int val : map.values()) {
            curr += val;
            maxOverlap = Math.max(maxOverlap, curr);
        }

        return maxOverlap;
    }
}