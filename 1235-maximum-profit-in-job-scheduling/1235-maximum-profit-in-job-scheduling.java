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
            // Option 1: don't take this job
            dp[i] = dp[i - 1];

            // Option 2: take this job
            int includeProfit = jobs[i].profit;

            // Find last non-overlapping job
            int j = i - 1;
            // can use binary search here
            while (j >= 0 && jobs[j].end > jobs[i].start) {
                j--;
            }

            if (j >= 0) {
                includeProfit += dp[j];
            }
            dp[i] = Math.max(dp[i], includeProfit);
        }

        return dp[n - 1];
    }
}
