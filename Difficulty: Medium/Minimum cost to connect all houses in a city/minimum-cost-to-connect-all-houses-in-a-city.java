//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                edges.add(new int[]{cost, i, j});
            }
        }
        
        Collections.sort(edges, Comparator.comparingInt(a -> a[0]));
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int res = 0, count = 0;
        for (int[] edge : edges) {
            int cost = edge[0], u = edge[1], v = edge[2];
            int pu = find(parent, u), pv = find(parent, v);
            if (pu != pv) {
                res += cost;
                parent[pu] = pv;
                count++;
                if (count == n - 1) break;
            }
        }
        return res;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
}