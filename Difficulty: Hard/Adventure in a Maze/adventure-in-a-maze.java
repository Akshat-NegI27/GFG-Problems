import java.util.*;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        final int MOD = 1000000007;

        long[][] ways = new long[n][n];
        int[][] max = new int[n][n];

        ways[0][0] = 1;
        max[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                // From top
                if (i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3)) {
                    ways[i][j] = ways[i - 1][j];
                    max[i][j] = max[i - 1][j];
                }

                // From left
                if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 3)) {
                    ways[i][j] = (ways[i][j] + ways[i][j - 1]) % MOD;
                    max[i][j] = Math.max(max[i][j], max[i][j - 1]);
                }

                // Add current cell's value to the maximum adventure
                if (ways[i][j] > 0) {
                    max[i][j] += grid[i][j];
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) ways[n - 1][n - 1]);
        ans.add(max[n - 1][n - 1]);

        return ans;
    }
}