class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        Integer[] temp = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));

        ArrayList<Integer> res = new ArrayList<>();
        for (int x : temp) {
            res.add(x);
        }

        return res;
    }
}