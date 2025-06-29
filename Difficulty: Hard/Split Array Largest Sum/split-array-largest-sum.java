class Solution {
    public int splitArray(int[] arr, int k) {
        int left = 0, right = 0;

        for (int num : arr) {
            left = Math.max(left, num); 
            right += num;               
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, k, mid)) {
                result = mid;          
                right = mid - 1;
            } else {
                left = mid + 1;        
            }
        }

        return result;
    }

    private boolean isValid(int[] arr, int k, int mid) {
        int count = 1;
        int currentSum = 0;

        for (int num : arr) {
            if (currentSum + num > mid) {
                count++;
                currentSum = num;
                if (count > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
};