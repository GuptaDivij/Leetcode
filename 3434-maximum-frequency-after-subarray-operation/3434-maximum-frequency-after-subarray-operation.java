class Solution {
    public int maxFrequency(int[] nums, int k) {
        int ctK = 0;
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
            if(num==k) ctK++;
        }
        int replaced = 0;
        for(int i = 1; i<=max; i++){
            if(i==k) continue;
            replaced = Math.max(replaced, replace(nums, i, k));
        }
        return replaced + ctK;
    }
    public int replace(int[] nums, int i, int k){
        int max = 0;
        int replaced = 0;
        for(int num : nums){
            if(num==i) replaced++;
            if(num==k) replaced--;
            if(replaced<0) replaced=0;
            max = Math.max(max, replaced);
        }
        return max;
    }
}

// 2 things we want to do -> 
// try to keep as many k's originally
// get a subarray with most duplicates