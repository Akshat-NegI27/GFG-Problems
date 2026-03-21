class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        int[] catalan = new int[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) left++;
                if (arr[j] > arr[i]) right++;
            }

            res.add(catalan[left] * catalan[right]);
        }

        return res;
    }
}