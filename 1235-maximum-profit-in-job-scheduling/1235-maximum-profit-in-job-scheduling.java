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

        // Sort by end time
        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {

            // Option 1: skip job
            int exclude = dp[i - 1];

            // Option 2: take job
            int include = jobs[i].profit;

            int prevIndex = findLastNonOverlapping(jobs, i);

            if (prevIndex != -1) {
                include += dp[prevIndex];
            }

            dp[i] = Math.max(exclude, include);
        }

        return dp[n - 1];
    }

    // Binary search for rightmost job whose end <= jobs[i].start
    private int findLastNonOverlapping(Job[] jobs, int i) {

        int left = 0;
        int right = i - 1;
        int targetStart = jobs[i].start;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (jobs[mid].end <= targetStart) {
                result = mid;       // possible answer
                left = mid + 1;     // try to find a later valid job
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
