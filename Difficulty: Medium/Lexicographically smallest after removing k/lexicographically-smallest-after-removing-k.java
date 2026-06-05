class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        if ((n & (n - 1)) == 0) {
            k /= 2;
        } else {
            k *= 2;
        }

        if (k >= n) {
            return "-1";
        }

        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peekLast() > ch) {
                st.pollLast();
                k--;
            }
            st.addLast(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            st.pollLast();
            k--;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.length() == 0 ? "-1" : ans.toString();
    }
}