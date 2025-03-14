//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int[][] dp;
    private int explore(int[] coins, int sum,int i)
    {
        if(sum==0 )return 1;
        if(i==coins.length)return 0;
        if(dp[i][sum]!=-1)return dp[i][sum];
        int exclude=explore(coins,sum,i+1);
        int include=0;
        if(sum-coins[i]>=0)
        {
            include=explore(coins,sum-coins[i],i);
          
        }
        return dp[i][sum]=include+exclude;
    }
    public int count(int coins[], int sum) {
        // code here.
        int c=coins.length;
        dp=new int[c+1][sum+1];
        for(int[] row: dp)
        {
        Arrays.fill(row,-1);
            
        }
        return explore(coins,sum,0);
    }
}