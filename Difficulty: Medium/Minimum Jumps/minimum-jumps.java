//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if (arr[0] == 0)
            return -1;
        int maxReach = 0;
        int currReach = 0;
        int jump = 0;
        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);
            if (maxReach >= n - 1) {
                return jump + 1;
            }
            if (i == currReach) {
                if (i == maxReach) {
                    return -1;
                }
                else {
                    jump++;
                    currReach = maxReach;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
}