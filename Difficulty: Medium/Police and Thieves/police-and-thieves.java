import java.util.*;

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length, count = 0;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thief = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thief.add(i);
            }

            while (!police.isEmpty() && !thief.isEmpty()) {
                if (Math.abs(police.peek() - thief.peek()) > k) {
                    if (police.peek() < thief.peek()) {
                        police.poll();
                    } else {
                        thief.poll();
                    }
                } else {
                    // match found
                    police.poll();
                    thief.poll();
                    count++;
                }
            }
        }

        return count;
    }
}
