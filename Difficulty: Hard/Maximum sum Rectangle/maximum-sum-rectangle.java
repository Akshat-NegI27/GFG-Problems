class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;

        int max_sum = Integer.MIN_VALUE;

        for (int l = 0; l < m; l++) {
            int[] temp = new int[n];

            for (int r = l; r < m; r++) {

                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][r];
                }

                int current_max = kadane(temp);
                max_sum = Math.max(max_sum, current_max);
            }
        }
        return max_sum;
    }

    private int kadane(int[] arr) {
        if (arr.length == 0) return 0;

        int max_so_far = arr[0];
        int current_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current_max = Math.max(arr[i], current_max + arr[i]);
            max_so_far = Math.max(max_so_far, current_max);
        }
        return max_so_far;
    }
}