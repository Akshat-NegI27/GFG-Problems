class Solution {
    public int numOfWays(int n, int m) {
        long totalCells = 1L * n * m;

        // Total ways to place black and white knight
        long totalWays = totalCells * (totalCells - 1);

        // Count attacking ordered pairs
        long attackingPairs = 0;

        attackingPairs += 4L * (n - 1) * (m - 2);
        attackingPairs += 4L * (n - 2) * (m - 1);

        return (int) (totalWays - attackingPairs);
    }
}