class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int maxKadane = kadane(arr); 
        int n = arr.length;

        int[] inverted = new int[n];
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            inverted[i] = -arr[i];
        }

        int maxInvertedKadane = kadane(inverted); 

        int maxWrap = totalSum + maxInvertedKadane; 

        if (maxWrap == 0) return maxKadane;

        return Math.max(maxKadane, maxWrap);
    }

    private int kadane(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }
}