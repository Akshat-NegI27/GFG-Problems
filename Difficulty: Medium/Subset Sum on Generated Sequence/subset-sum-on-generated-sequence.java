class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) return true;

        long sum = s;
        java.util.ArrayList<Long> seq = new java.util.ArrayList<>();

        seq.add((long) s);

        for (int i = 0; i < arr.length; i++) {
            long next = sum + arr[i];

            if (next > x) {
                break;
            }

            seq.add(next);
            sum += next;
        }

        // Greedy: take the largest value <= remaining x
        long target = x;

        for (int i = seq.size() - 1; i >= 0; i--) {
            if (seq.get(i) <= target) {
                target -= seq.get(i);
            }

            if (target == 0) {
                return true;
            }
        }

        return false;
    }
}