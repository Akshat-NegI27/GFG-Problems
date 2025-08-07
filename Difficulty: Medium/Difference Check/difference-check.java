class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0; 
        }

        int[] timesInSeconds = new int[n];
        for (int i = 0; i < n; i++) {
            String[] timeParts = arr[i].split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int seconds = Integer.parseInt(timeParts[2]);

            timesInSeconds[i] = hours * 3600 + minutes * 60 + seconds;
        }

        Arrays.sort(timesInSeconds);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = timesInSeconds[i] - timesInSeconds[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        int wrapAroundDiff = (24 * 3600) - timesInSeconds[n - 1] + timesInSeconds[0];
        if (wrapAroundDiff < minDiff) {
            minDiff = wrapAroundDiff;
        }

        return minDiff;
    }
}