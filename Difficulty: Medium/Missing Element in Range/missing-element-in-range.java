class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int x : arr) {
            set.add(x);
        }

        for (int i = low; i <= high; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}