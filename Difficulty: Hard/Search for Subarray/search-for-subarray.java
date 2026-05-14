class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = a.length;
        int m = b.length;

        int[] lps = new int[m];
        buildLPS(b, lps);

        int i = 0, j = 0;

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;

                if (j == m) {
                    res.add(i - m);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return res;
    }

    void buildLPS(int[] pat, int[] lps) {
        int len = 0;
        int i = 1;

        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}