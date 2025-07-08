class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && freq.get(arr[stack.peek()]) <= freq.get(arr[i])) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.set(i, arr[stack.peek()]);
            }

            stack.push(i);
        }

        return result;
    }
}