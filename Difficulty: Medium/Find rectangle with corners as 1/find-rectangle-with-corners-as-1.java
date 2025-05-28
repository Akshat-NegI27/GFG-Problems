class Solution {
    public boolean ValidCorner(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (mat[k][i] == 1 && mat[k][j] == 1) {
                        count++;
                        if (count == 2) return true;
                    }
                }
            }
        }
        return false;
    }
}
