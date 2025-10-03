
class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        backtrack(arr, 0, new StringBuilder(), mapping, result);
        return result;
    }

    private void backtrack(int[] arr, int idx, StringBuilder sb, String[] mapping, ArrayList<String> result) {
        if (idx == arr.length) {
            if (sb.length() > 0) result.add(sb.toString()); // avoid adding empty string
            return;
        }
        String letters = mapping[arr[idx]];
        if (letters.isEmpty()) {
            // skip this digit (0 or 1) and continue
            backtrack(arr, idx + 1, sb, mapping, result);
        } else {
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(arr, idx + 1, sb, mapping, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
