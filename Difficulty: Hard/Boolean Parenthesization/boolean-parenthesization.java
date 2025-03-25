//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.countWays(s));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Map<String, int[]> memo;

    static int countWays(String s) {
        memo = new HashMap<>();
        return solve(0, s.length() - 1, s, true);
    }

    static int solve(int i, int j, String s, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }

        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return isTrue ? memo.get(key)[0] : memo.get(key)[1];
        }

        int trueCount = 0, falseCount = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            char operator = s.charAt(k);

            int leftTrue = solve(i, k - 1, s, true);
            int leftFalse = solve(i, k - 1, s, false);
            int rightTrue = solve(k + 1, j, s, true);
            int rightFalse = solve(k + 1, j, s, false);

            switch (operator) {
                case '&':
                    trueCount += leftTrue * rightTrue;
                    falseCount += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                    break;
                case '|':
                    trueCount += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    falseCount += leftFalse * rightFalse;
                    break;
                case '^':
                    trueCount += leftTrue * rightFalse + leftFalse * rightTrue;
                    falseCount += leftTrue * rightTrue + leftFalse * rightFalse;
                    break;
            }
        }

        memo.put(key, new int[]{trueCount, falseCount});
        return isTrue ? trueCount : falseCount;
    }
}
