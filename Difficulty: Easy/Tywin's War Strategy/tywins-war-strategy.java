class Solution {
    public int minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2; // ceil(n/2)
        int lucky = 0;
        List<Integer> additions = new ArrayList<>();

        for (int soldiers : arr) {
            if (soldiers % k == 0) {
                lucky++;
            } else {
                additions.add(k - (soldiers % k));
            }
        }

        if (lucky >= required) return 0;

        Collections.sort(additions);
        int need = required - lucky;
        int total = 0;
        for (int i = 0; i < need; i++) {
            total += additions.get(i);
        }
        return total;
    }
}
