class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }

            if (pq.size() < k) {
                res.add(-1);
            } else {
                res.add(pq.peek());
            }
        }

        return res;
    }
}