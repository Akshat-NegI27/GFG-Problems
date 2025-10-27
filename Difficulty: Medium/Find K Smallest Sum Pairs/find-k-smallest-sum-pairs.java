class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        for (int i = 0; i < arr1.length && i < k; i++) pq.offer(new int[]{arr1[i], arr2[0], 0});
        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            result.add(new ArrayList<>(Arrays.asList(curr[0], curr[1])));
            if (curr[2] + 1 < arr2.length) pq.offer(new int[]{curr[0], arr2[curr[2] + 1], curr[2] + 1});
        }
        return result;
    }
}
