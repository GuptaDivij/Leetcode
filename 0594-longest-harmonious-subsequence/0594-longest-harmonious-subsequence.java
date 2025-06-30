class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int ans = 0;
        while(i<nums.length){
            int nextStart = i+1;
            while(nextStart<nums.length && nums[nextStart]==nums[i]) nextStart++;
            if(nextStart == nums.length) break;
            if(nums[nextStart]!=nums[i]+1){
                i = nextStart;
                continue;
            }
            int j = nextStart;
            while(j<nums.length && nums[j]==nums[i]+1) j++;
            ans = Math.max(ans, j-i);
            i=nextStart;
        }
        return ans;
    }
}