class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) res.add(-1);

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && freq.get(arr[st.peek()]) < freq.get(arr[i])) {
                res.set(st.pop(), arr[i]);
            }
            st.push(i);
        }
        return res;
    }
}