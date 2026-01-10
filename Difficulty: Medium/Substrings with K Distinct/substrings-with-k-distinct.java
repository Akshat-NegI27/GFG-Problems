class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return atMost(s, k) - atMost(s, k - 1);
    }
    
    private int atMost(String s, int k) {
        int[] freq = new int[26];
        int left = 0, distinct = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';
            if (freq[r]++ == 0) distinct++;
            while (distinct > k) {
                int l = s.charAt(left++) - 'a';
                if (--freq[l] == 0) distinct--;
            }
            res += right - left + 1;
        }
        return res;
    }
}