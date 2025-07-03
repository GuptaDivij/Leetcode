class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int idx = 0;

        while (idx <= two) {
            if (nums[idx] == 0) {
                int temp = nums[zero];
                nums[zero] = 0;
                nums[idx] = temp;
                zero++;
                idx++;
            } else if (nums[idx] == 2) {
                int temp = nums[two];
                nums[two] = 2;
                nums[idx] = temp;
                two--;
            } else {
                idx++;
            }
        }
    }
}
