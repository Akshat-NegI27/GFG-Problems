class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n < 1) return result;

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.poll();       
            result.add(s);             

            q.add(s + "0");            
            q.add(s + "1");            
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ArrayList<String> binaries = sol.generateBinary(6);
        System.out.println(binaries);
    }
}
