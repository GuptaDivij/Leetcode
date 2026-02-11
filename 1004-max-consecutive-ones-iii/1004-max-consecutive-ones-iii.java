class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int currZeroes = 0;
        int maxOnes = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                currZeroes++;
                while(start<nums.length && currZeroes>k){
                    if(nums[start] == 0){
                        currZeroes--;
                    }
                    start++;
                }
            }
            maxOnes = Math.max(maxOnes, i-start+1);
        }
        return maxOnes;
    }
}