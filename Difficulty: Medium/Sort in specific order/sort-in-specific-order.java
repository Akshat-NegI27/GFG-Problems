class Solution {
    public void sortIt(int[] arr) {
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        
        for (int x : arr) {
            if ((x & 1) == 1) odds.add(x);
            else evens.add(x);
        }
        
        // Sort odds descending
        odds.sort((a, b) -> b - a);
        
        // Sort evens ascending
        Collections.sort(evens);
        
        int idx = 0;
        
        for (int x : odds) arr[idx++] = x;
        for (int x : evens) arr[idx++] = x;
    }
}
