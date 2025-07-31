class Solution {
    public int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int current = 0;
        int maxPowerful = -1;
        int prev = -1;

        for (int point : map.keySet()) {
            if (prev != -1 && current >= k) {
                maxPowerful = Math.max(maxPowerful, point - 1);
            }

            current += map.get(point);
            prev = point;
        }

        return maxPowerful;
    }
}
