class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int x : arr) {
            int curr = x;

            while (!st.isEmpty() && (long)st.peek() * curr < 0) {
                int top = st.pop();

                if (Math.abs(top) > Math.abs(curr)) {
                    curr = top;
                } else if (Math.abs(top) == Math.abs(curr)) {
                    curr = 0;
                    break;
                }
            }

            if (curr != 0) st.push(curr);
        }

        return new ArrayList<>(st);
    }
}