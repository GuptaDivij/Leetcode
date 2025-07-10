class Solution {
    public int maxFreeTime(int eventTime, int[] start, int[] end) {
        int n = start.length;
        boolean[] movable = new boolean[n];

        int maxGapLeft = 0, maxGapRight = 0;

        // left-to-right scan
        for (int i = 0; i < n; i++) {
            int dur = end[i] - start[i];
            if (dur <= maxGapLeft) movable[i] = true;
            maxGapLeft = Math.max(maxGapLeft, start[i] - (i == 0 ? 0 : end[i - 1]));
        }

        // right-to-left scan
        for (int i = n - 1; i >= 0; i--) {
            int dur = end[i] - start[i];
            if (dur <= maxGapRight) movable[i] = true;
            maxGapRight = Math.max(maxGapRight,
                                   (i == n - 1 ? eventTime : start[i + 1]) - end[i]);
        }

        int best = 0;
        for (int i = 0; i < n; i++) {
            int left  = (i == 0)     ? 0          : end[i - 1];
            int right = (i == n - 1) ? eventTime  : start[i + 1];
            int free  = movable[i] ? right - left
                                   : right - left - (end[i] - start[i]);
            best = Math.max(best, free);
        }
        return best;
    }
}
