class Solution {
    static class State {
        int len, link;
        int[] next = new int[26];

        State() {
            link = -1;
            for (int i = 0; i < 26; i++) next[i] = -1;
        }
    }

    static State[] st;
    static int last, size;

    static void saInit() {
        st = new State[6005]; // 2 * max length
        for (int i = 0; i < 6005; i++) st[i] = new State();
        last = 0;
        size = 1;
    }

    static void extend(char c) {
        int cur = size++;
        st[cur].len = st[last].len + 1;
        int p = last;
        int cidx = c - 'a';

        while (p != -1 && st[p].next[cidx] == -1) {
            st[p].next[cidx] = cur;
            p = st[p].link;
        }

        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next[cidx];
            if (st[p].len + 1 == st[q].len) {
                st[cur].link = q;
            } else {
                int clone = size++;
                st[clone].len = st[p].len + 1;
                st[clone].link = st[q].link;
                for (int i = 0; i < 26; i++) st[clone].next[i] = st[q].next[i];

                while (p != -1 && st[p].next[cidx] == q) {
                    st[p].next[cidx] = clone;
                    p = st[p].link;
                }

                st[q].link = st[cur].link = clone;
            }
        }
        last = cur;
    }

    public static int countSubs(String s) {
        saInit();
        for (char c : s.toCharArray()) extend(c);

        long result = 0;
        for (int i = 1; i < size; i++) {
            result += st[i].len - st[st[i].link].len;
        }

        return (int) result;
    }
}
