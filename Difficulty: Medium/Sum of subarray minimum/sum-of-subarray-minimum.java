class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            result = (result + (long)arr[i] * prevLess[i] * nextLess[i]) % mod;
        }

        return (int)result;
    }
}