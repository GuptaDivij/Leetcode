// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used a ct variable to represent the present streak - if I encounter a valid streak (the differences match) I add ct to res and increment it for if we find the next element to be valid in the streak as at every point we get one additional option for eg - 1,2,3,4,5 ct at 3 is 1 as only one option (1,2,3), then at 4 ct is 2 as 2 more options - starting in reverse from 4, we have 2 possible stops - 2 and 1 (2,3,4) and (1,2,3,4) then at 5 we have 3 possible additional stops - 3,2,1 - (3,4,5), (2,3,4,5) and (1,2,3,4,5) - I do not care about others as they have already been counted for. If the streak breaks, I simply reset my diff and ct to be 1.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int res = 0;
        int ct = 1;
        int diff = nums[1]-nums[0];
        for(int i = 2; i<nums.length; i++){
            if(nums[i]-nums[i-1]==diff){
                res+=ct;
                ct++;
            }
            else{
                ct=1;
                diff=nums[i]-nums[i-1];
            }
        }
        return res;
    }
}