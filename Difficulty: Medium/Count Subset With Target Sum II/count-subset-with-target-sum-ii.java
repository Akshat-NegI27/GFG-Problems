class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        ArrayList<Long> leftSums = new ArrayList<>();
        ArrayList<Long> rightSums = new ArrayList<>();

        generateSums(left, 0, 0L, leftSums);
        generateSums(right, 0, 0L, rightSums);

        Collections.sort(rightSums);

        int count = 0;
        for (long ls : leftSums) {
            long target = k - ls;
            count += upperBound(rightSums, target) - lowerBound(rightSums, target);
        }
        return count;
    }

    private void generateSums(int[] arr, int idx, long sum, ArrayList<Long> res) {
        if (idx == arr.length) {
            res.add(sum);
            return;
        }
        generateSums(arr, idx + 1, sum, res);
        generateSums(arr, idx + 1, sum + arr[idx], res);
    }

    private int lowerBound(ArrayList<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int upperBound(ArrayList<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
