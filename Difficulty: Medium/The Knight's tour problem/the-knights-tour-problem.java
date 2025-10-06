class Solution {
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private ArrayList<ArrayList<Integer>> ans;
    private int[][] board;
    private int n;

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        this.n = n;
        ans = new ArrayList<>();
        board = new int[n][n];
        for (int[] row : board) Arrays.fill(row, -1);
        board[0][0] = 0;
        if (solve(0, 0, 1)) {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) row.add(board[i][j]);
                ans.add(row);
            }
        }
        return ans;
    }

    private boolean solve(int x, int y, int move) {
        if (move == n * n) return true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == -1) {
                board[nx][ny] = move;
                if (solve(nx, ny, move + 1)) return true;
                board[nx][ny] = -1;
            }
        }
        return false;
    }
}