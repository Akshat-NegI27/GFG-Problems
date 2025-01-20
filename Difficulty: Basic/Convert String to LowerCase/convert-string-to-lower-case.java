//{ Driver Code Starts
// Initial template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.toLower(s));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function template for Java

class Solution {
    static String toLower(String s) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            n.append(Character.toLowerCase(s.charAt(i)));
        }
        return n.toString(); // Convert StringBuilder to a String
    }
}

