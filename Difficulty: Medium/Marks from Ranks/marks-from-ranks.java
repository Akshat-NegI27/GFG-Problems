class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {

        ArrayList<Integer> ans = new ArrayList<>();

        // prefix[i] = number of valid marks up to interval i
        long[] prefix = new long[l.length];

        for (int i = 0; i < l.length; i++) {
            long size = (long) r[i] - l[i] + 1;

            if (i == 0) {
                prefix[i] = size;
            } else {
                prefix[i] = prefix[i - 1] + size;
            }
        }

        for (int k : rank) {

            // Find the first interval whose prefix count >= k
            int low = 0;
            int high = l.length - 1;

            while (low < high) {

                int mid = low + (high - low) / 2;

                if (prefix[mid] >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int i = low;

            // Number of elements before this interval
            long before = (i == 0) ? 0 : prefix[i - 1];

            // Offset inside current interval
            long offset = k - before - 1;

            int mark = (int) (l[i] + offset);

            ans.add(mark);
        }

        return ans;
    }
}