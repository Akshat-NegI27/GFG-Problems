//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    String max;

    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        solve(arr, k, 0);
        return max;
    }

   private void solve(char[] arr, int k, int index) {
    if (k == 0 || index >= arr.length) return;

    char maxDigit = arr[index];
    for (int i = index + 1; i < arr.length; i++) {
        if (arr[i] > maxDigit) {
            maxDigit = arr[i];
        }
    }

    if (maxDigit != arr[index]) k--;

    for (int i = arr.length - 1; i >= index; i--) {
        if (arr[i] == maxDigit) {
            swap(arr, index, i);
            String current = new String(arr);
            if (current.compareTo(max) > 0) {
                max = current;
            }
            solve(arr, k, index + 1);
            swap(arr, index, i); // backtrack
        }
    }
}


    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
