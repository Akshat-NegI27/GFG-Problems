class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) return 1;

        int base = a.charAt(a.length() - 1) - '0';

        int expMod4 = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod4 = (expMod4 * 10 + (b.charAt(i) - '0')) % 4;
        }

        int exp = (expMod4 == 0) ? 4 : expMod4;

        int ans = 1;
        for (int i = 0; i < exp; i++) {
            ans = (ans * base) % 10;
        }

        return ans;
    }
}