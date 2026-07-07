class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        boolean[] blockedRow = new boolean[n + 1];
        boolean[] blockedCol = new boolean[m + 1];

        for (int[] cell : arr) {
            blockedRow[cell[0]] = true;
            blockedCol[cell[1]] = true;
        }

        int maxRows = 0, curr = 0;
        for (int i = 1; i <= n; i++) {
            if (!blockedRow[i]) {
                curr++;
                maxRows = Math.max(maxRows, curr);
            } else {
                curr = 0;
            }
        }

        int maxCols = 0;
        curr = 0;
        for (int j = 1; j <= m; j++) {
            if (!blockedCol[j]) {
                curr++;
                maxCols = Math.max(maxCols, curr);
            } else {
                curr = 0;
            }
        }

        return maxRows * maxCols;
    }
}