class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> groups = new TreeMap<>();

        Runnable add = null;
        Runnable remove = null;

        class Helper {
            void addElement(int x) {
                int oldFreq = freq.getOrDefault(x, 0);
                if (oldFreq > 0) {
                    groups.get(oldFreq).remove(x);
                    if (groups.get(oldFreq).isEmpty()) groups.remove(oldFreq);
                }
                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);
                groups.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);
            }

            void removeElement(int x) {
                int oldFreq = freq.get(x);
                groups.get(oldFreq).remove(x);
                if (groups.get(oldFreq).isEmpty()) groups.remove(oldFreq);

                int newFreq = oldFreq - 1;
                if (newFreq == 0) {
                    freq.remove(x);
                } else {
                    freq.put(x, newFreq);
                    groups.computeIfAbsent(newFreq, f -> new TreeSet<>()).add(x);
                }
            }
        }

        Helper helper = new Helper();

        for (int i = 0; i < k; i++) {
            helper.addElement(arr[i]);
        }

        long sum = 0;

        for (int i = k; i <= n; i++) {

            int maxFreq = groups.lastKey();
            int mode = groups.get(maxFreq).first();
            sum += mode;

            if (i == n) break; 

            helper.removeElement(arr[i - k]);
            helper.addElement(arr[i]);
        }

        return (int) sum;
    }
}