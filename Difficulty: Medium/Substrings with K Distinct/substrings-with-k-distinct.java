// User function Template for Java

class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (right = 0; right < n; right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            // Shrink the window until we have at most k distinct characters
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            // Add all substrings ending at right with at most k distinct characters
            count += right - left + 1;
        }

        return count;
    }
}