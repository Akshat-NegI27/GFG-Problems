class Solution {
    public static String caseSort(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        // Lists to store uppercase and lowercase characters separately
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        // Separate characters by case
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                upper.add(c);
            } else {
                lower.add(c);
            }
        }

        // Sort both lists
        Collections.sort(upper);
        Collections.sort(lower);

        // Pointers to access sorted characters
        int u = 0, l = 0;
        StringBuilder result = new StringBuilder();

        // Reconstruct string based on original character case
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                result.append(upper.get(u++));
            } else {
                result.append(lower.get(l++));
            }
        }

        return result.toString();
    }
}
