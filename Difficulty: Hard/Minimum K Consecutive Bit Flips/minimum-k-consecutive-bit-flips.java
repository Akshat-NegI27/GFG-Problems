class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] flipped = new int[n];  
        int flipCount = 0;           
        int operations = 0;

        for (int i = 0; i < n; i++) {

            if (i >= k) {
                flipCount ^= flipped[i - k];
            }

            if ((arr[i] ^ flipCount) == 0) {
                if (i + k > n) return -1; 
                operations++;
                flipCount ^= 1;      
                flipped[i] = 1;      
            }
        }

        return operations;
    }
}