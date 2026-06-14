class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int i = 0, j = 0;
        int dir = 0; 

        while (true) {

            if (mat[i][j] == 1) {
                dir = (dir + 1) % 4;
                mat[i][j] = 0;
            }

            int ni = i, nj = j;

            if (dir == 0) nj++;
            else if (dir == 1) ni++;
            else if (dir == 2) nj--;
            else ni--;

            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                return Arrays.asList(i, j);
            }

            i = ni;
            j = nj;
        }
    }
}