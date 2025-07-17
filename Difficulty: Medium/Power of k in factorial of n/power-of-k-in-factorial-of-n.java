class Solution {
    public int maxKPower(int n, int k) {
        int result = Integer.MAX_VALUE;
        for (int i = 2; i * i <= k; i++) {
            int count = 0;
            while (k % i == 0) {
                count++;
                k /= i;
            }
            if (count > 0) {
                int powerInFact = 0, temp = n;
                while (temp > 0) {
                    powerInFact += temp / i;
                    temp /= i;
                }
                result = Math.min(result, powerInFact / count);
            }
        }
        if (k > 1) {
            int powerInFact = 0, temp = n;
            while (temp > 0) {
                powerInFact += temp / k;
                temp /= k;
            }
            result = Math.min(result, powerInFact);
        }
        return result;
    }
}
