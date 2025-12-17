class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> res = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int s = arr[i][0];
            int e = arr[i][1];

            if (s <= end) {
                end = Math.max(end, e);
            } else {
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        res.add(new int[]{start, end});
        return res;
    }
}
