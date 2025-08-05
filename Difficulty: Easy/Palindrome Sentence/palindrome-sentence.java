class Solution {
    public boolean isPalinSent(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                char charLeft = Character.toLowerCase(s.charAt(left));
                char charRight = Character.toLowerCase(s.charAt(right));

                if (charLeft != charRight) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}