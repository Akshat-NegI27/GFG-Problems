class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] incRight = new int[n];
        incRight[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                incRight[i] = incRight[i + 1];
            else
                incRight[i] = i;
        }

        int[] decRight = new int[n];
        decRight[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                decRight[i] = decRight[i + 1];
            else
                decRight[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int peak = incRight[l];
            ans.add(decRight[peak] >= r);
        }

        return ans;
    }
}