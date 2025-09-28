class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int l = 0, bestStart = 0, bestLen = 0;

        for (int r = 0; r < n; r++) {

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[r]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(r);

            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[r]) {
                minDeque.pollLast();
            }
            minDeque.addLast(r);

            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                l++;
                if (maxDeque.peekFirst() < l) maxDeque.pollFirst();
                if (minDeque.peekFirst() < l) minDeque.pollFirst();
            }

            if (r - l + 1 > bestLen) {
                bestLen = r - l + 1;
                bestStart = l;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}