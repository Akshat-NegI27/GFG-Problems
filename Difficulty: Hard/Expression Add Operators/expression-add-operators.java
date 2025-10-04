class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        backtrack(result, "", s, target, 0, 0, 0);
        Collections.sort(result); 
        return result;
    }

    private void backtrack(ArrayList<String> result, String path, String s,
                           int target, int pos, long eval, long multed) {
        if (pos == s.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        for (int i = pos; i < s.length(); i++) {

            if (i != pos && s.charAt(pos) == '0') break;

            String currStr = s.substring(pos, i + 1);
            long curr = Long.parseLong(currStr);

            if (pos == 0) {

                backtrack(result, path + currStr, s, target, i + 1, curr, curr);
            } else {

                backtrack(result, path + "+" + currStr, s, target, i + 1, eval + curr, curr);

                backtrack(result, path + "-" + currStr, s, target, i + 1, eval - curr, -curr);

                backtrack(result, path + "*" + currStr, s, target, i + 1,
                          eval - multed + multed * curr, multed * curr);
            }
        }
    }
}