class Solution {
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    int lcmTriplets(int n) {
        long res;

        if (n <= 2) return n;

        if (n % 2 != 0) {
            res = lcm(n, lcm(n - 1, n - 2));
        } else {
            if (n % 3 != 0) {
                res = lcm(n, lcm(n - 1, n - 3));
            } else {
                res = lcm(n - 1, lcm(n - 2, n - 3));
            }
        }
        return (int) res;
    }
}
