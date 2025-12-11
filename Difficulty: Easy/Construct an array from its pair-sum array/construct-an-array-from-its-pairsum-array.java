class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        int m = arr.length;

        // find n from m = n*(n-1)/2
        int n = (int) ((1 + Math.sqrt(1 + 8L * m)) / 2);

        ArrayList<Integer> res = new ArrayList<>(n);

        if (n == 2) {
            // arr = [res0 + res1]
            res.add(1);
            res.add(arr[0] - 1);
            return res;
        }

        long s01 = arr[0];
        long s02 = arr[1];
        long s12 = arr[n - 1];

        long r0 = (s01 + s02 - s12) / 2;
        long r1 = s01 - r0;
        long r2 = s02 - r0;

        res.add((int) r0);
        res.add((int) r1);
        res.add((int) r2);

        // remaining: arr[j-1] = res[0] + res[j]
        for (int j = 3; j < n; j++) {
            long rj = arr[j - 1] - r0;
            res.add((int) rj);
        }

        return res;
    }
}
