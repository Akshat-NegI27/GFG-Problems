
class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> res = new ArrayList<>();
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return res;
        boolean[][] vis = new boolean[n][n];
        solve(0, 0, maze, n, vis, "", res);
        Collections.sort(res);
        return res;
    }

    private void solve(int x, int y, int[][] maze, int n, boolean[][] vis, String path, ArrayList<String> res) {
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }
        vis[x][y] = true;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !vis[nx][ny] && maze[nx][ny] == 1)
                solve(nx, ny, maze, n, vis, path + dir[i], res);
        }
        vis[x][y] = false;
    }
}
