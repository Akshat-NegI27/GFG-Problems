class Solution {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int pos = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[pos++] = arr[i];
            }
        }

        while (pos < n) {
            arr[pos++] = 0;
        }
    }
}