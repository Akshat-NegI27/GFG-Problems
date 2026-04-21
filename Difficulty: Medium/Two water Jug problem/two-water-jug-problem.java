class Solution {
    
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    int pour(int fromCap, int toCap, int d) {
        int from = fromCap;
        int to = 0;
        int step = 1;
        
        while (from != d && to != d) {
            int temp = Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            step++;
            
            if (from == d || to == d) break;
            
            if (from == 0) {
                from = fromCap;
                step++;
            }
            
            if (to == toCap) {
                to = 0;
                step++;
            }
        }
        
        return step;
    }
    
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;
        
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
}