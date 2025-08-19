class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;

        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[]{arr[i], i});
        }

        Collections.sort(vec, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            int num = vec.get(i)[0];
            int idx = vec.get(i)[1];

            if (i > 0 && vec.get(i - 1)[0] == num) {
                int x = ans.get(vec.get(i - 1)[1]);
                if (x > idx) {
                    ans.set(idx, x);
                }
            } else {
                if (maxi > idx) {
                    ans.set(idx, maxi);
                }
            }
            maxi = Math.max(maxi, idx);
        }

        return ans;
    }
}