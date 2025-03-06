//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static int lcs(String s1, String s2) {
        // code here
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int m = s1.length();
        int n= s2.length();
        int memo[][]=new int[m+1] [n+1];
        for(int []row:memo)
        Arrays.fill(row,-1);
        int res= subseq(c1,c2,m,n,memo);
        return res;
    }
    static int subseq(char s1[],char s2[],int m ,int n , int memo[][])
    {
        if(m==0||n==0)
        return memo[m][n]=0;
        if(memo[m][n]!=-1)
        return memo[m][n];
        if(s1[m-1]==s2[n-1])
        memo[m][n]=1+subseq(s1,s2,m-1,n-1,memo);
        else
        memo[m][n]=Math.max(subseq(s1,s2,m,n-1,memo),subseq(s1,s2,m-1,n,memo));
        return memo[m][n];
    }
}