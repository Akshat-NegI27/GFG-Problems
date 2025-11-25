import java.util.*;

class Solution {
    static class DSU {
        int[] p, r;
        DSU(int n) { p = new int[n]; r = new int[n]; for (int i=0;i<n;i++) p[i]=i; }
        int find(int x) { return p[x]==x?x:(p[x]=find(p[x])); }
        boolean union(int a,int b){ a=find(a); b=find(b); if(a==b) return false; if(r[a]<r[b]) p[a]=b; else if(r[b]<r[a]) p[b]=a; else { p[b]=a; r[a]++; } return true; }
    }

    int[][] up;
    int[][] max1;
    int[][] max2;
    int[] depth;
    List<List<int[]>> mst;

    void dfs(int u,int p,int w){
        up[u][0]=p;
        max1[u][0]=w;
        max2[u][0]=-1;
        for(int[] e: mst.get(u)){
            int v=e[0], wt=e[1];
            if(v==p) continue;
            depth[v]=depth[u]+1;
            dfs(v,u,wt);
        }
    }

    int[] combinePair(int a1,int a2,int b1,int b2){
        // produce top two distinct values (first = largest, second = largest strictly < first or -1)
        int[] cand = new int[]{a1,a2,b1,b2};
        int first = -1, second = -1;
        for(int x: cand){
            if(x>first){
                second = first;
                first = x;
            } else if(x<first && x>second){
                second = x;
            }
        }
        return new int[]{first, second};
    }

    int[] queryMaxs(int a,int b,int LOG){
        int best1 = -1, best2 = -1;
        if(depth[a] < depth[b]) { int t=a; a=b; b=t; }
        int diff = depth[a] - depth[b];
        for(int i=0;i<LOG;i++){
            if((diff & (1<<i)) != 0){
                int[] r = combinePair(best1,best2, max1[a][i], max2[a][i]);
                best1 = r[0]; best2 = r[1];
                a = up[a][i];
            }
        }
        if(a==b) return new int[]{best1,best2};
        for(int i=LOG-1;i>=0;i--){
            if(up[a][i] != up[b][i]){
                int[] r1 = combinePair(best1,best2, max1[a][i], max2[a][i]);
                best1 = r1[0]; best2 = r1[1];
                int[] r2 = combinePair(best1,best2, max1[b][i], max2[b][i]);
                best1 = r2[0]; best2 = r2[1];
                a = up[a][i];
                b = up[b][i];
            }
        }
        int[] rA = combinePair(best1,best2, max1[a][0], max2[a][0]);
        best1 = rA[0]; best2 = rA[1];
        int[] rB = combinePair(best1,best2, max1[b][0], max2[b][0]);
        best1 = rB[0]; best2 = rB[1];
        return new int[]{best1,best2};
    }

    public int secondMST(int V, int[][] edges) {
        int E = edges.length;
        Arrays.sort(edges, new Comparator<int[]>() {
            public int compare(int[] a,int[] b){ return a[2]-b[2]; }
        });
        DSU dsu = new DSU(V);
        boolean[] used = new boolean[E];
        int mstW = 0, cnt = 0;
        for(int i=0;i<E;i++){
            int u=edges[i][0], v=edges[i][1], w=edges[i][2];
            if(dsu.union(u,v)){ used[i]=true; mstW+=w; cnt++; }
        }
        if(cnt != V-1) return -1;
        mst = new ArrayList<>();
        for(int i=0;i<V;i++) mst.add(new ArrayList<>());
        for(int i=0;i<E;i++) if(used[i]) {
            int u=edges[i][0], v=edges[i][1], w=edges[i][2];
            mst.get(u).add(new int[]{v,w});
            mst.get(v).add(new int[]{u,w});
        }
        int LOG = 17;
        up = new int[V][LOG];
        max1 = new int[V][LOG];
        max2 = new int[V][LOG];
        depth = new int[V];
        for(int i=0;i<V;i++) for(int j=0;j<LOG;j++){ up[i][j]=0; max1[i][j]=-1; max2[i][j]=-1; }
        dfs(0,0, -1);
        for(int j=1;j<LOG;j++){
            for(int i=0;i<V;i++){
                int p = up[i][j-1];
                up[i][j] = up[p][j-1];
                int[] r = combinePair(max1[i][j-1], max2[i][j-1], max1[p][j-1], max2[p][j-1]);
                max1[i][j] = r[0]; max2[i][j] = r[1];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<E;i++){
            if(used[i]) continue;
            int u=edges[i][0], v=edges[i][1], w=edges[i][2];
            int[] qq = queryMaxs(u,v,LOG);
            int m1 = qq[0], m2 = qq[1];
            if(m1 == -1) continue;
            if(w > m1){
                int val = mstW + w - m1;
                if(val > mstW && val < ans) ans = val;
            } else if(w == m1){
                if(m2 != -1){
                    int val = mstW + w - m2;
                    if(val > mstW && val < ans) ans = val;
                }
            } else {
                int val = mstW + w - m1;
                if(val > mstW && val < ans) ans = val;
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
