class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        backtrack(arr, used, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] arr, boolean[] used,
                                  ArrayList<Integer> curr,
                                  ArrayList<ArrayList<Integer>> res) {
        if (curr.size() == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(arr[i]);
                backtrack(arr, used, curr, res);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}