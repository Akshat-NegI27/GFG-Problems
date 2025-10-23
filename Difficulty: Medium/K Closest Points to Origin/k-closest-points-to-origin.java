class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] p : points) {
            int x = p[0], y = p[1];
            int distSq = x * x + y * y; 

            pq.offer(new int[]{distSq, x, y});

            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            result.add(new ArrayList<>(Arrays.asList(p[1], p[2])));
        }

        return result;
    }
}