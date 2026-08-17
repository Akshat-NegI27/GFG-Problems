class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int total = n * n;

        int[] jump = new int[total + 1];

        // No snake/ladder by default
        for (int i = 1; i <= total; i++) {
            jump[i] = i;
        }

        // Ladders
        for (int i = 0; i < lad.length; i += 2) {
            jump[lad[i]] = lad[i + 1];
        }

        // Snakes
        for (int i = 0; i < sn.length; i += 2) {
            jump[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[total + 1];

        // BFS queue: {cell, throws}
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cell = curr[0];
            int throwsCount = curr[1];

            if (cell == total) {
                return throwsCount;
            }

            // One dice throw: move 1 to 6 cells
            for (int dice = 1; dice <= 6; dice++) {
                int next = cell + dice;

                if (next > total) {
                    break;
                }

                // Take snake/ladder immediately
                next = jump[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}