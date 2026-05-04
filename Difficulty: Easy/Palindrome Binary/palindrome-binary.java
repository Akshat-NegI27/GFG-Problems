class Solution {
    static long isPallindrome(long N) {
        String bin = Long.toBinaryString(N);
        int i = 0, j = bin.length() - 1;

        while (i < j) {
            if (bin.charAt(i) != bin.charAt(j)) {
                return 0;
            }
            i++;
            j--;
        }

        return 1;
    }
}