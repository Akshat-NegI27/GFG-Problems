class Solution {
    public int substrCount(String s, int k) {
        if (k > s.length()) {
            return 0;
        }

        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);

            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            if (right - left + 1 == k) {
                if (freqMap.size() == k - 1) {
                    count++;
                }
            }
        }

        return count;
    }
}