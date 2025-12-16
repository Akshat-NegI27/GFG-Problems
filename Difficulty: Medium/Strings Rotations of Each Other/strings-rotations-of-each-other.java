class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String text = s1 + s1;
        return kmp(text, s2) != -1;
    }

    private int kmp(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == m) return i - m; 
            } else {
                if (j > 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0, i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
