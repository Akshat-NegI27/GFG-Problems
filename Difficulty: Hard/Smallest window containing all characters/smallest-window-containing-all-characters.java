import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] need = new int[256]; 
        int[] have = new int[256]; 

        for (char c : p.toCharArray()) {
            need[c]++;
        }

        int required = p.length(); 
        int left = 0, minLen = Integer.MAX_VALUE, start = -1;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            have[c]++;
            if (need[c] > 0 && have[c] <= need[c]) {
                required--;
            }

            while (required == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                have[leftChar]--;
                if (need[leftChar] > 0 && have[leftChar] < need[leftChar]) {
                    required++;
                }
                left++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}