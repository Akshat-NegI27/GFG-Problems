class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer> rank = new HashMap<>();
        for (int i = 0; i < n; i++) rank.put(sorted[i], i);
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        for (int i = 1; i <= n; i++) {
            long v = 0;
            for (int j = 0; j < i; j++) v += (long)catalan[j] * catalan[i - j - 1];
            catalan[i] = (int)v;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : arr) {
            int left = rank.get(x);
            int right = n - left - 1;
            result.add(catalan[left] * catalan[right]);
        }
        return result;
    }
}
