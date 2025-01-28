//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        Set<String> ans = new HashSet();
        boolean[] visit = new boolean[s.length()];
        makePermutation(s, ans, "", visit);
        return new ArrayList(ans);
    }
    static void makePermutation(String s, Set<String> ans, String curr, boolean[] visit){
        if(curr.length() == s.length()){
            ans.add(curr);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!visit[i]){
                visit[i] = true;
                makePermutation(s, ans, curr+s.charAt(i),visit);
                visit[i]=false;
            }
        }
    }
}