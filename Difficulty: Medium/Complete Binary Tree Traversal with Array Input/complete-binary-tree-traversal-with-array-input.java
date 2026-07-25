class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int idx = 0;
        int levelSize = 1;

        while (idx < n) {
            ArrayList<Integer> level = new ArrayList<>();

            int cnt = Math.min(levelSize, n - idx);
            for (int i = 0; i < cnt; i++) {
                level.add(arr[idx++]);
            }

            Collections.sort(level);
            ans.add(level);
            levelSize <<= 1;
        }

        return ans;
    }
}