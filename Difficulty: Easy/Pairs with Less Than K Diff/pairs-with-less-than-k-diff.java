class Solution {
    public static int countPairs(int arr[], int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int ans = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] - arr[i] < k) {
                j++;
            }
            ans += j - i - 1;
        }

        return ans;
    }
}