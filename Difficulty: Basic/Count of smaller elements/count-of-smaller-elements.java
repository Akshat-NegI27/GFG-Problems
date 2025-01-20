//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public int countOfElements(int x, List<Integer> arr) {
        int cnt = 0;  // Initialize the count variable
        for (int num : arr) {
            if (num <= x) {  // Check if the element is less than or equal to x
                cnt++;  // Increment the count
            }
        }
        return cnt;  // Return the final count
    }
}

//{ Driver Code Starts.

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int x = Integer.parseInt(sc.nextLine());
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Solution ob = new Solution();
            int ans = ob.countOfElements(x, arr);
            System.out.println(ans);
        
System.out.println("~");
}
        sc.close();
    }
}

// } Driver Code Ends