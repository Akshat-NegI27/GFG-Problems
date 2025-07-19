class Solution {
    public int vowelCount(String s) {

        long[] counts = new long[5]; 
        for (char c : s.toCharArray()) {
            if (c == 'a') counts[0]++;
            else if (c == 'e') counts[1]++;
            else if (c == 'i') counts[2]++;
            else if (c == 'o') counts[3]++;
            else if (c == 'u') counts[4]++;
        }

        long productOfCounts = 1;
        int numberOfUniqueVowels = 0;
        for (long count : counts) {
            if (count > 0) {
                productOfCounts *= count;
                numberOfUniqueVowels++;
            }
        }

        if (numberOfUniqueVowels == 0) {
            return 0;
        }

        long permutations = 1;
        for (int i = 1; i <= numberOfUniqueVowels; i++) {
            permutations *= i;
        }

        long total = productOfCounts * permutations;

        return (int) total;
    }
}