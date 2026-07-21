class Solution {
    public int minDeletions(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int len = 0;

        for (int x : arr) {
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (lis[mid] < x)
                    l = mid + 1;
                else
                    r = mid;
            }
            lis[l] = x;
            if (l == len) len++;
        }

        return n - len;
    }
}