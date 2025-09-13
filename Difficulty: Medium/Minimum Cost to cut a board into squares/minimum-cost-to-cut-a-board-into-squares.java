class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Integer[] X = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] Y = Arrays.stream(y).boxed().toArray(Integer[]::new);
        Arrays.sort(X, Collections.reverseOrder());
        Arrays.sort(Y, Collections.reverseOrder());
        
        int i = 0, j = 0;
        int hz = 1, vt = 1;
        int cost = 0;
        
        while (i < X.length && j < Y.length) {
            if (X[i] >= Y[j]) {
                cost += X[i] * hz;
                vt++;
                i++;
            } else {
                cost += Y[j] * vt;
                hz++;
                j++;
            }
        }
        
        while (i < X.length) {
            cost += X[i] * hz;
            vt++;
            i++;
        }
        
        while (j < Y.length) {
            cost += Y[j] * vt;
            hz++;
            j++;
        }
        
        return cost;
    }
}
