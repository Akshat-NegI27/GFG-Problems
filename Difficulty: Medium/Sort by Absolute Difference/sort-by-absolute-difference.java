class Solution {
    public void rearrange(int[] arr, int x) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new int[]{arr[i], i});
        }
        Collections.sort(list, (a, b) -> {
            int d1 = Math.abs(a[0] - x);
            int d2 = Math.abs(b[0] - x);
            if (d1 != d2) return d1 - d2;
            return a[1] - b[1];
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }
    }
}
