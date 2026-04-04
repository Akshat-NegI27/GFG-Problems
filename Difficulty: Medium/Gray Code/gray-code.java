class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> res = new ArrayList<>();
        int size = 1 << n;

        for (int i = 0; i < size; i++) {
            int gray = i ^ (i >> 1);
            String bin = Integer.toBinaryString(gray);

            while (bin.length() < n) {
                bin = "0" + bin;
            }

            res.add(bin);
        }

        return res;
    }
}