//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        ArrayList<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{profit[i], deadline[i]});
        }

        jobs.sort((a, b) -> Integer.compare(b[0], a[0]));
        int[] slot = new int[n];
        int cnt = 0;
        int totProfit = 0;

        for (int i = 0; i < n; i++) {
            int deadlineIndex = Math.min(n, jobs.get(i)[1]) - 1;
            for (int j = deadlineIndex; j >= 0; j--) {
                if (slot[j] == 0) {
                    slot[j] = 1;
                    cnt++;
                    totProfit += jobs.get(i)[0];
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(cnt);
        result.add(totProfit);
        return result;
    }
}



//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends