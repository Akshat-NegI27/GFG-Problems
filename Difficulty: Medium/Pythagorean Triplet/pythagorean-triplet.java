class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) set.add(a * a);

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int a2 = arr[i] * arr[i];
            for (int j = i + 1; j < n; j++) {
                int b2 = arr[j] * arr[j];
                if (set.contains(a2 + b2)) return true;
            }
        }
        return false;
    }
}