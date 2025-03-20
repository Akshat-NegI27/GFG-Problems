//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int dp[][][];
    public static int maxProfit(int[] prices) {
                int k = 2;

        dp = new int[prices.length][k+1][2];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        
        return solve(prices,k,0,0);
    }
    
    static int solve(int prices[], int k, int idx, int holding){
        if(idx == prices.length){
            return 0;
        }
        if(k == 0){
            return 0;
        }
        
        if(dp[idx][k][holding] != -1){
            return dp[idx][k][holding];
        }
        int transaction = 0;
        if(holding == 1){
            transaction = prices[idx] + solve(prices,k-1,idx+1,0);
        } else {
            transaction = -prices[idx] + solve(prices,k,idx+1,1);
        }
        int np_transact = solve(prices,k,idx+1,holding);
        return dp[idx][k][holding] = Math.max(transaction, np_transact);
    }
}