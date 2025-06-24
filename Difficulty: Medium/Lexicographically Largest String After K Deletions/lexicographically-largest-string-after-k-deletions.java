class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int toKeep = n - k;
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) < ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // The result should be of size (n - k)
        return stack.substring(0, toKeep);
    }
}
