class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        
        // Try all pairs of first and second numbers
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; i + j < n; j++) {
                String a = s.substring(0, i);
                String b = s.substring(i, i + j);
                
                // Check for leading zeros
                if ((a.length() > 1 && a.startsWith("0")) || (b.length() > 1 && b.startsWith("0")))
                    continue;

                if (isValid(s, a, b, i + j))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid(String s, String a, String b, int start) {
        if (start == s.length())
            return true;

        String sum = addStrings(a, b);
        int sumLen = sum.length();

        if (start + sumLen > s.length())
            return false;

        String next = s.substring(start, start + sumLen);

        if (!next.equals(sum))
            return false;

        return isValid(s, b, sum, start + sumLen);
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int d2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
