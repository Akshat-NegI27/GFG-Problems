class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        
        int[] freq = new int[26];
        for (char c : p.toCharArray()) freq[c - 'a']++;
        
        int left = 0, count = p.length(), minLen = Integer.MAX_VALUE, start = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right) - 'a']-- > 0) count--;
            
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                if (++freq[s.charAt(left) - 'a'] > 0) count++;
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}