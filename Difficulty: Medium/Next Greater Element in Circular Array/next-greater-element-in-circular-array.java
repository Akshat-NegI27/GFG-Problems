class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>(); // store indices

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            int num = arr[idx];

            while (!stack.isEmpty() && arr[stack.peek()] <= num) {
                stack.pop();
            }

            if (i < n && !stack.isEmpty()) {
                res.set(idx, arr[stack.peek()]);
            }

            stack.push(idx);
        }

        return res;
    }
}
