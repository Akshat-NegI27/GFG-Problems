class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        long sumMax = 0, sumMin = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] < arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                sumMax += (long) arr[mid] * (mid - left) * (right - mid);
            }
            st.push(i);
        }

        st.clear();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || arr[st.peek()] > arr[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                sumMin += (long) arr[mid] * (mid - left) * (right - mid);
            }
            st.push(i);
        }

        return (int) (sumMax - sumMin);
    }
}
