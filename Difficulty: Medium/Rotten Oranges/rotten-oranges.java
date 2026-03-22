class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int time = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                
                for (int[] d : dir) {
                    int ni = cur[0] + d[0];
                    int nj = cur[1] + d[1];
                    
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && mat[ni][nj] == 1) {
                        mat[ni][nj] = 2;
                        fresh--;
                        q.add(new int[]{ni, nj});
                    }
                }
            }
        }
        
        return fresh == 0 ? time : -1;
    }
}