class Solution {
    int n;
    int[][] mat;
    int[][] path;
    boolean[][] failed;

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        this.mat = mat;
        n = mat.length;
        path = new int[n][n];
        failed = new boolean[n][n];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (mat[0][0] == 0 || !dfs(0, 0)) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(-1);
            ans.add(row);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(path[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    boolean dfs(int i, int j) {
        if (i >= n || j >= n || mat[i][j] == 0)
            return false;

        if (failed[i][j])
            return false;

        if (path[i][j] == 1)
            return false;

        path[i][j] = 1;

        if (i == n - 1 && j == n - 1)
            return true;

        int jump = mat[i][j];

        for (int k = 1; k <= jump; k++) {
            // Right first
            if (j + k < n && dfs(i, j + k))
                return true;

            // Then Down
            if (i + k < n && dfs(i + k, j))
                return true;
        }

        path[i][j] = 0;
        failed[i][j] = true; // Memoize dead end
        return false;
    }
}