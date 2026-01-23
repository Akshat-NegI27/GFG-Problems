
class Solution {
    void p(int[] arr, int[] pge) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    void n(int[] arr, int[] nge) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        int[] nge = new int[n];

        p(arr, pge);
        n(arr, nge);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int totalVisible = nge[i] - pge[i] - 1;
            ans = Math.max(ans, totalVisible);
        }
        return ans;
    }
}
