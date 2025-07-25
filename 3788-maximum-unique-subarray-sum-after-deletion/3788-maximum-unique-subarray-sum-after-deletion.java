class Solution {
    public int maxSum(int[] nums) {
        int sum = nums[0];
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int i = 1; i<nums.length; i++){
            int n = nums[i];
            if(set.contains(n)) continue;
            set.add(n);
            if(n<0 || sum<0) sum = Math.max(sum, n);
            else sum+=n;
        }
        return sum;
    }
}

// delete the negatives and the ones seen before