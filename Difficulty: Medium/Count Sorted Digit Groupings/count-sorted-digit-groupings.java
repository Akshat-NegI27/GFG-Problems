import java.util.*;

class Solution {
    int[][] dp;
    int[] prefix;
    int n;

    public int validGroups(String s) {
        n = s.length();

        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) - '0');
        }

        dp = new int[n + 1][901];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0);
    }

    int solve(int idx, int prevSum) {
        if (idx == n) {
            return 1;
        }

        if (dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }

        int ans = 0;

        for (int j = idx; j < n; j++) {
            int currSum = prefix[j + 1] - prefix[idx];

            if (currSum >= prevSum) {
                ans += solve(j + 1, currSum);
            }
        }

        return dp[idx][prevSum] = ans;
    }
}