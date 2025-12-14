class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {

        int n = mat.length, m = mat[0].length;
        int[][] pref = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pref[i][j] = mat[i - 1][j - 1] 
                            + pref[i - 1][j] 
                            + pref[i][j - 1] 
                            - pref[i - 1][j - 1];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            r1++; c1++; r2++; c2++;
            int sum = pref[r2][c2] - pref[r1 - 1][c2] 
                     - pref[r2][c1 - 1] + pref[r1 - 1][c1 - 1];
            ans.add(sum);
        }

        return ans;
    }
}
