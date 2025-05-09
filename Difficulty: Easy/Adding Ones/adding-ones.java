//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int updates[] = new int[k];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < k; i++) {
                updates[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.update(a, n, updates, k);
            
            StringBuilder output = new StringBuilder();
            for(int i = 0; i < n; i++)
            output.append(a[i] + " ");
            System.out.println(output);
            
        
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static void update(int a[], int n, int updates[], int k)
    {
        // Your code goes here
        for (int x : updates) {
            ++a[x-1]; 
       }
       
       int sum = a[0];
       for (int i=1; i<n; i++) {
            a[i] += sum;
            sum = a[i];
       }
    }
}
