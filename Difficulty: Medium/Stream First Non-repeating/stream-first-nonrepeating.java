class Solution {
    public String firstNonRepeating(String s) {
        int[] freq = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            q.offer(c);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            ans.append(q.isEmpty() ? '#' : q.peek());
        }
        return ans.toString();
    }
}
