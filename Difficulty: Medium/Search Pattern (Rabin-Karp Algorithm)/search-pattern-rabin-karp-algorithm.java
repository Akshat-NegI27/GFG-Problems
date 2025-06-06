class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        int d = 256; 
        int q = 101; 
        int m = pat.length();
        int n = txt.length();

        if (m > n) return result;

        int p = 0; 
        int t = 0; 
        int h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {

            if (p == t) {

                int j;
                for (j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                if (j == m)
                    result.add(i + 1); 
            }

            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                if (t < 0)
                    t = (t + q);
            }
        }

        return result;
    }
}