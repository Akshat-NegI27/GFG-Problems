class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate("", n, result);
        return result;
    }

    private void generate(String prefix, int n, ArrayList<String> result) {
        if (n == 0) {
            result.add(prefix);
            return;
        }
        generate(prefix + "0", n - 1, result);
        generate(prefix + "1", n - 1, result);
    }
}
