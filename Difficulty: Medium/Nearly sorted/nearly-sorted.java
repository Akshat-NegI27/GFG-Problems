class Solution {
    public void nearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = arr.length;
        int index = 0;

        for (int i = 0; i <= k && i < n; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            arr[index++] = pq.poll();  
            pq.add(arr[i]);            
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}