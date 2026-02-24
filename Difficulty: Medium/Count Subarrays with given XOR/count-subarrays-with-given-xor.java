class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        long count = 0;

        map.put(0, 1);

        for (int num : arr) {
            prefixXor ^= num;

            int target = prefixXor ^ k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}