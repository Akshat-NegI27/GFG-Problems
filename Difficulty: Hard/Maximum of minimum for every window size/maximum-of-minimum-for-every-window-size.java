//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];

        Arrays.fill(prev, -1);
        Arrays.fill(next, n);

        Stack<Integer> stack = new Stack<>();

        // Finding previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prev[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Finding next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                next[i] = stack.peek();
            }
            stack.push(i);
        }

        // Storing max of minimums for different window sizes
        int[] maxOfMins = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int length = next[i] - prev[i] - 1;
            maxOfMins[length] = Math.max(maxOfMins[length], arr[i]);
        }

        // Filling the values for the result
        for (int i = n - 1; i >= 1; i--) {
            maxOfMins[i] = Math.max(maxOfMins[i], maxOfMins[i + 1]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(maxOfMins[i]);
        }

        return result;
    }
}
