class Solution {
    public static int sumSubstrings(String s) {
        long sum = 0;
        long mf = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - '0') * (i + 1) * mf;
            mf = mf * 10 + 1;
        }
        return (int)sum;
    }
}