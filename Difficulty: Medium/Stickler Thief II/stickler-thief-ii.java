//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int n = s.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] arr = IntArray.input(br);

            Solution obj = new Solution();
            int res = obj.maxValue(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(f1(n-2, arr, dp1, false), f1(n-1, arr, dp2, true));
    }
    int f1(int ind, int arr[], int dp[], boolean fl){
        if(fl==false)
        if(ind<0) return 0;
        if(fl==true)
        if(ind<=0) return 0;
        
        if(dp[ind]!=-1) return dp[ind];
        
        int nt = f1(ind-1, arr, dp,fl);
        int t = arr[ind] + f1(ind-2, arr, dp,fl);
        
        return dp[ind] = Math.max(nt, t);
    }
}