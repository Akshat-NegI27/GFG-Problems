class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int odd = 0;
        
        for (int f : freq) {
            if (f % 2 != 0) odd++;
        }
        
        return odd <= 1;
    }
}