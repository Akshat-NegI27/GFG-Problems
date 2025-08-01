class Solution {

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int countBalanced(String[] arr) {
        int n = arr.length;
        
        Map<Integer, Long> freqMap = new HashMap<>();
        
        long currentPrefixSum = 0;
        long balancedSubstrings = 0;

        freqMap.put(0, 1L);

        for (String s : arr) {
            int vowelCount = 0;
            for (char c : s.toCharArray()) {
                if (isVowel(c)) {
                    vowelCount++;
                }
            }
            int consonantCount = s.length() - vowelCount;
            int diff = vowelCount - consonantCount;
            
            currentPrefixSum += diff;
            
            if (freqMap.containsKey((int) currentPrefixSum)) {
                balancedSubstrings += freqMap.get((int) currentPrefixSum);
            }
            
            freqMap.put((int) currentPrefixSum, freqMap.getOrDefault((int) currentPrefixSum, 0L) + 1);
        }
        
        return (int) balancedSubstrings;
    }
}