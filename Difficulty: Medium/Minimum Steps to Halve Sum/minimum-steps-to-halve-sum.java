class Solution {
    public int minOperations(int[] arr) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;

        for (int num : arr) {
            maxHeap.offer((double) num);
            sum += num;
        }

        double halfSum = sum / 2;
        double currentSum = sum;
        int operations = 0;

        while (currentSum > halfSum) {
            double largest = maxHeap.poll();
            double reduced = largest / 2.0;
            currentSum -= reduced;  
            maxHeap.offer(reduced);
            operations++;
        }

        return operations;
    }
}