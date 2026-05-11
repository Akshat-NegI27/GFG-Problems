import java.util.*;

class Solution {
    public boolean palindromePair(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            int n = s.length();

            for (int j = 0; j <= n; j++) {
                String left = s.substring(0, j);
                String right = s.substring(j);

                if (isPalindrome(left)) {
                    String rev = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }

                if (j != n && isPalindrome(right)) {
                    String rev = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}