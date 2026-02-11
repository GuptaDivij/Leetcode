import java.util.*;

class Solution {

    class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort by start time
        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        int[] dp = new int[n];

        dp[n - 1] = jobs[n - 1].profit;

        for (int i = n - 2; i >= 0; i--) {

            // Option 1: skip current job
            int exclude = dp[i + 1];

            // Option 2: take current job
            int include = jobs[i].profit;

            int nextIndex = findNextNonOverlapping(jobs, i);

            if (nextIndex != -1) {
                include += dp[nextIndex];
            }

            dp[i] = Math.max(exclude, include);
        }

        return dp[0];
    }

    // Binary search for first job whose start >= jobs[i].end
    private int findNextNonOverlapping(Job[] jobs, int i) {

        int left = i + 1;
        int right = jobs.length - 1;
        int targetEnd = jobs[i].end;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs[mid].start >= targetEnd) {
                result = mid;
                right = mid - 1;  // try to find earlier valid job
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
