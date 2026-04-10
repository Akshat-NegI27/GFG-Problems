class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = -1;
        int minIdx = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIdx]) {
                minIdx = i;
                leftMin[i] = -1;
            } else {
                leftMin[i] = minIdx;
            }
        }

        rightMax[n - 1] = -1;
        int maxIdx = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIdx]) {
                maxIdx = i;
                rightMax[i] = -1;
            } else {
                rightMax[i] = maxIdx;
            }
        }

        for (int i = 0; i < n; i++) {
            if (leftMin[i] != -1 && rightMax[i] != -1) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(arr[leftMin[i]]);
                res.add(arr[i]);
                res.add(arr[rightMax[i]]);
                return res;
            }
        }

        return new ArrayList<>();
    }
}