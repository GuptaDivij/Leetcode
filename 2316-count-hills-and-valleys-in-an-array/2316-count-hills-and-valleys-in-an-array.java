class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int left = 0;
        int i = 1;

        while (i < nums.length) {
            if (nums[i] == nums[left]) {
                i++;
                continue;
            }
            int right = i + 1;
            while (right < nums.length && nums[right] == nums[i]) right++;
            if (right < nums.length) {
                if (nums[i] > nums[left] && nums[i] > nums[right]) count++;
                else if (nums[i] < nums[left] && nums[i] < nums[right]) count++;
            }
            left = i;
            i = right;
        }
        return count;
    }
}
