class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n == 1) return 1;

        int[][] lap = new int[n][n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            lap[u][u]++;
            lap[v][v]++;
            lap[u][v]--;
            lap[v][u]--;
        }

        int size = n - 1;
        double[][] mat = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = lap[i][j];
            }
        }

        double det = determinant(mat, size);
        return (int)Math.round(det);
    }

    double determinant(double[][] a, int n) {
        double det = 1;

        for (int i = 0; i < n; i++) {
            int pivot = i;
            while (pivot < n && Math.abs(a[pivot][i]) < 1e-9) pivot++;

            if (pivot == n) return 0;

            if (pivot != i) {
                double[] temp = a[i];
                a[i] = a[pivot];
                a[pivot] = temp;
                det *= -1;
            }

            det *= a[i][i];

            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                for (int k = i; k < n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }

        return det;
    }
}