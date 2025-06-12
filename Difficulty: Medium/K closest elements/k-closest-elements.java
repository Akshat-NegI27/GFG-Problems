class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // sort by |a - x|
            } else {
                return b[1] - a[1]; // if tie, prefer larger element
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) continue; // exclude x if it exists
            pq.offer(new int[]{Math.abs(arr[i] - x), arr[i]});
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result[i] = pq.poll()[1];
        }

        return result;
    }
}