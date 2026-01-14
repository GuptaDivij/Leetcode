class Solution {
    public void nextPermutation(int[] nums) {
        // from the right, find the first pair of numbers which are in increasing order
        // for 1,2,3,1; 2,3 is the first pair.
        // replace the first element of this pair with the smallest number to the right which is greater than this (we want to increase the number) which is 3 in this case
        // so now we have 1,3,2,1, now 3 is fixed, after that 3, we need the numbers in ascending order
        // since we first checked for decressing order, numbers are already sorted, we just reverse them
        // so now we have 1,3,1,2
        int pair1 = nums.length-2;
        while(pair1>=0 && nums[pair1]>=nums[pair1+1]) pair1--; // descending order, will stop as soon as any pair in increasing order is found
        if(pair1>=0){
            // we find the first element which is greater than current element
            int first = nums.length-1;
            while(nums[first]<=nums[pair1]) first--;
            swap(nums, first, pair1);
        }
        reverse(nums, pair1+1);
    }
    public void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int [] nums, int start){
        int end = nums.length-1;
        while(start<end){
            swap(nums, start++, end--);
        }
    }
}