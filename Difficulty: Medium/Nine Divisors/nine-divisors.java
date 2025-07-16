import java.util.*;

class Solution {
    public static int countNumbers(int n) {
        int limit = (int) Math.sqrt(n);
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;

        // Count p^8
        for (int p : primes) {
            long p8 = 1L * p;
            for (int e = 0; e < 7; e++) p8 *= p;
            if (p8 <= n) count++;
            else break; // no bigger p will work
        }

        // Count p^2 * q^2
        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = 1L * primes.get(i) * primes.get(i);
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                long q2 = 1L * primes.get(j) * primes.get(j);
                if (p2 * q2 <= n) count++;
                else break; // further q are larger
            }
        }

        return count;
    }
}
