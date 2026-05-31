class Solution {
    public boolean isSumOfConsecutive(int n) {
        return n > 0 && (n & (n - 1)) != 0;
    }
}