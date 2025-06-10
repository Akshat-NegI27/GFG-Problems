class Solution {
    public int countStrings(String s) {
        int n = s.length();
        int ans = n * (n - 1) / 2;

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        boolean hasDuplicates = false;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1) {
                hasDuplicates = true;
                ans -= (freq[i] * (freq[i] - 1)) / 2;
            }
        }

        return hasDuplicates ? ans + 1 : ans;
    }
}
