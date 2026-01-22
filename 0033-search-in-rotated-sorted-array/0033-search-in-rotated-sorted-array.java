class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return mid;
            // if nums[mid] > nums[low], it is ascending till mid and we can directly perform binary search in this if target is in middle of this
            if(nums[low]<=nums[mid]){
                if(nums[mid]>target && target>=nums[low]) high = mid-1;
                else low = mid+1;
            }
            // else, mid is lower than low, so it is ascending from mid to high, if it exist in that range, we update
            else{
                if(target>nums[mid] && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
}