class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];

        int[] prefMax = new int[n + 1];
        int[] suffMax = new int[n + 2];
        prefMax[0] = gaps[0];
        for (int i = 1; i <= n; i++) prefMax[i] = Math.max(prefMax[i - 1], gaps[i]);
        suffMax[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) suffMax[i] = Math.max(suffMax[i + 1], gaps[i]);

        int ans = prefMax[n];

        for (int i = 0; i < n; i++) {
            int dur = endTime[i] - startTime[i];
            int largestElsewhere = Math.max(i > 0 ? prefMax[i - 1] : 0,
                                            (i + 2 <= n) ? suffMax[i + 2] : 0);
            if (largestElsewhere >= dur) {
                int merged = gaps[i] + dur + gaps[i + 1];
                ans = Math.max(ans, merged);
            }
        }

        for (int i = 0; i < n; i++) {
            int dur = endTime[i] - startTime[i];
            int prevEnd = (i == 0) ? 0 : endTime[i - 1];
            int nextStart = (i == n - 1) ? eventTime : startTime[i + 1];

            int newStart = nextStart - dur;
            if (newStart >= prevEnd) ans = Math.max(ans, newStart - prevEnd);

            int newEnd = prevEnd + dur;
            if (newEnd <= nextStart) ans = Math.max(ans, nextStart - newEnd);

            if (dur <= startTime[0]) ans = Math.max(ans, startTime[0] - dur);
            if (dur <= eventTime - endTime[n - 1])
                ans = Math.max(ans, eventTime - endTime[n - 1] - dur);
        }
        return ans;
    }
}
