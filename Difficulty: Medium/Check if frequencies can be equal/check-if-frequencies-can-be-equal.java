class Solution {
    public boolean sameFreq(String s) {
        int[] freq = new int[26];

        // Populate character frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxFreqValue = Integer.MIN_VALUE;
        int minFreqValue = Integer.MAX_VALUE;
        int maxFreqCounter = 0;
        int minFreqCounter = 0;

        for (int f : freq) {

            if (f == 0) continue;

            if (f == maxFreqValue) {

                maxFreqCounter++;
            }
            if (f == minFreqValue) {

                minFreqCounter++;
            }
            if (f > maxFreqValue) {

                maxFreqValue = f;
                maxFreqCounter = 1;
            }
            if (f < minFreqValue) {

                minFreqValue = f;
                minFreqCounter = 1;
            }
        }

        if ((maxFreqValue - minFreqValue) == 0) {
            return true;
        } else if ((maxFreqValue - minFreqValue) == 1 &&
                   (maxFreqCounter == 1 ||
                    (minFreqCounter == 1 && minFreqValue == 1))) {
            return true;
        }

        return false;
    }
}