class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start % n : -1;
    }
}
