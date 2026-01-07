class Solution {
    public int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    private int atMost(int[] arr, int k) {
        if (k < 0) return 0;

        int left = 0, count = 0, res = 0;

        for (int right = 0; right < arr.length; right++) {
            if ((arr[right] & 1) == 1)
                count++;

            while (count > k) {
                if ((arr[left] & 1) == 1)
                    count--;
                left++;
            }

            res += right - left + 1;
        }

        return res;
    }
}