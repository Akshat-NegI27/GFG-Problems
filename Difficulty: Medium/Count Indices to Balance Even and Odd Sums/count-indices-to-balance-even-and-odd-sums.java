class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;

        int[] preEven = new int[n];
        int[] preOdd = new int[n];

        preEven[0] = arr[0];

        for (int i = 1; i < n; i++) {
            preEven[i] = preEven[i - 1];
            preOdd[i] = preOdd[i - 1];

            if (i % 2 == 0)
                preEven[i] += arr[i];
            else
                preOdd[i] += arr[i];
        }

        int totalEven = preEven[n - 1];
        int totalOdd = preOdd[n - 1];

        int count = 0;

        for (int i = 0; i < n; i++) {

            int evenLeft = (i == 0 ? 0 : preEven[i - 1]);
            int oddLeft  = (i == 0 ? 0 : preOdd[i - 1]);

            int evenRight = totalEven - preEven[i];
            int oddRight  = totalOdd - preOdd[i];

            int newEvenSum = evenLeft + oddRight;
            int newOddSum  = oddLeft + evenRight;

            if (newEvenSum == newOddSum)
                count++;
        }

        return count;
    }
}
