class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low<high){
            int mid = (high+low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid;
        }
        return -1;
    }
}