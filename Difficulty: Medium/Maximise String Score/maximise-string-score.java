import java.util.*;

class Solution {
    public int maxScore(String s, char[][] jumps) {

        int n = s.length();

        List<List<Integer>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) graph.add(new ArrayList<>());

        for (char[] pr : jumps) {
            int u = pr[0] - 'a';
            int v = pr[1] - 'a';
            if (u != v) graph.get(u).add(v);
        }

        for (int i = 0; i < 26; i++) graph.get(i).add(i);

        int[] prefix = new int[n + 1];
        int[][] charPrefix = new int[26][n + 1];
        int[] dp = new int[n + 2];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        for (int ch = 0; ch < 26; ch++) {
            for (int j = 1; j <= n; j++) {
                int ele = s.charAt(j - 1) - 'a';
                charPrefix[ch][j] = charPrefix[ch][j - 1];
                if (ele == ch) charPrefix[ch][j] += s.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + s.charAt(i - 1);

        for (int i = n; i >= 1; i--) {

            int curEle = s.charAt(i - 1) - 'a';

            for (int prev : graph.get(curEle)) {
                int forwPos = pos[prev];
                if (forwPos == -1) continue;

                int sameCharPrefix = charPrefix[prev][forwPos] - charPrefix[prev][i - 1];
                int tp = dp[forwPos] + (prefix[forwPos] - prefix[i - 1] - sameCharPrefix);

                dp[i] = Math.max(dp[i], tp);
            }

            pos[curEle] = i;
        }

        return dp[1];
    }
}
