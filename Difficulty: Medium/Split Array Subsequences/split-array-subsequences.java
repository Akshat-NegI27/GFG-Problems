class Solution {

    public boolean isPossible(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == 0) continue;

            if (need.getOrDefault(num, 0) > 0) {
                need.put(num, need.get(num) - 1);
                need.put(num + 1, need.getOrDefault(num + 1, 0) + 1);
            }

            else {
                for (int i = 0; i < k; i++) {
                    if (freq.getOrDefault(num + i, 0) <= 0) return false;
                    freq.put(num + i, freq.get(num + i) - 1);
                }
                need.put(num + k, need.getOrDefault(num + k, 0) + 1);
                continue;
            }

            freq.put(num, freq.get(num) - 1);
        }

        return true;
    }
}