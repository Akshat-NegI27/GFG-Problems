class Solution {
    public int findIndex(String s) {
        int n = s.length();

        int totalClosing = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                totalClosing++;
            }
        }

        int openLeft = 0;
        int closeRight = totalClosing;

        for (int i = 0; i <= n; i++) {
            if (openLeft == closeRight) {
                return i;
            }

            if (i < n) {
                if (s.charAt(i) == '(') {
                    openLeft++;
                } else {
                    closeRight--;
                }
            }
        }

        return n;
    }
}