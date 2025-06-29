class Solution {
    public int climbStairs(int n) {
        int[]dp = new int[n+1];
        int twoStep = 1;
        int oneStep = 1;
        for(int i=2; i<n+1;i++){
            int totalStep = oneStep+twoStep;
            twoStep = oneStep;
            oneStep = totalStep;
        }
        return oneStep;
    }
}