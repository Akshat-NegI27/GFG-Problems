class Solution {
    public boolean divby13(String s) {
        int mod = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            mod = (mod * 10 + digit) % 13;
        }
        return mod == 0;
    }
}
