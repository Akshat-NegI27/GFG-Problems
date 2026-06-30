class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> seq = new ArrayList<>();
        for (int x : a) {
            if (map.containsKey(x)) {
                seq.add(map.get(x));
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : seq) {
            int idx = lowerBound(lis, x);
            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        int lcs = lis.size();
        return (a.length - lcs) + (b.length - lcs);
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}