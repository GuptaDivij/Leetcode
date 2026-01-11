class Solution {
    public int trap(int[] height) {
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        for (int i = 1, j = height.length-2; i<height.length && j>=0; i++, j--){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }
        int ans = 0;
        for (int i = 0; i<height.length; i++){
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }
}