class Solution {
    public int countValid(int n, int[] arr) {
        boolean[] allowed = new boolean[10];
        for (int d : arr) allowed[d] = true;

        int total = 9 * (int) Math.pow(10, n - 1);

        int invalid = 0;
        for (int first = 1; first <= 9; first++) {
            if (!allowed[first]) {
                invalid += countInvalidCombinations(first, n - 1, allowed);
            }
        }

        return total - invalid;
    }

    private int countInvalidCombinations(int firstDigit, int remainingDigits, boolean[] allowed) {
        int[] notAllowedDigits = new int[10];
        int count = 0;
        for (int d = 0; d <= 9; d++) {
            if (!allowed[d]) {
                notAllowedDigits[count++] = d;
            }
        }
        if (count == 0) return 0;

        int res = 1;
        for (int i = 0; i < remainingDigits; i++) res *= count;
        return res;
    }
}
