class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[1]-b[1]); // sort based on end time
        // int[][] dp -> dp[i][j] tells max value attending j meetings and at max till i length
        int[][] dp = new int[n+1][k+1];
        
        for(int i = 1; i<=n; i++){
            int start = events[i-1][0];
            int end = events[i-1][1];
            int value = events[i-1][2];
            // binary search to last meeting that does not overlap
            int lastMeeting = noOverLap(events, i-1);
            for(int j = 1; j<=k; j++){
                // dp[i][j-1] take this to skip adding this meeting
                // value + dp[lastMeeting][j-1] take last possible meeting time
                // and j-1 meetings with it and add current value
                dp[i][j] = Math.max(dp[i-1][j], value + dp[lastMeeting][j-1]);
            }
        }
        return dp[n][k];
    }
    public int noOverLap(int[][] events, int i){
        int low = 0;
        int high = i - 1;
        // the next endtime should be before start time
        int startTime = events[i][0];
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            // need to move left
            if (events[mid][1] < startTime) {
                ans = mid + 1; 
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}