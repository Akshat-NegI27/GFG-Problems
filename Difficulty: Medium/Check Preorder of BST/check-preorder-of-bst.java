class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val < root) return false;

            while (!st.isEmpty() && val > st.peek()) {
                root = st.pop();
            }

            st.push(val);
        }

        return true;
    }
}