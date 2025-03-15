//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    int[][] dp;

    private int explore(int[] coins, int sum, int i) {
        if (sum == 0) return 0;  
        if (i == coins.length) return Integer.MAX_VALUE - 1; 

        if (dp[i][sum] != -1) return dp[i][sum];

        int exclude = explore(coins, sum, i + 1); 
        int include = Integer.MAX_VALUE - 1;

        if (sum - coins[i] >= 0) {
            include = 1 + explore(coins, sum - coins[i], i); 
        }

        return dp[i][sum] = Math.min(include, exclude); 
    }

    public int minCoins(int coins[], int sum) {
        int c = coins.length;
        dp = new int[c + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = explore(coins, sum, 0);
        return (result == Integer.MAX_VALUE - 1) ? -1 : result; 
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends