class Solution {
    public String longestString(String[] words) {
        Arrays.sort(words);
        Set<String> valid = new HashSet<>();
        String result = "";
        for (String word : words) {
            if (word.length() == 1 || valid.contains(word.substring(0, word.length() - 1))) {
                valid.add(word);
                if (word.length() > result.length() || 
                   (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
}
