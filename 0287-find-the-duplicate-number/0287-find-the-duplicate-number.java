class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// i-> node
// nums[i] -> next
// [1, 3, 4, 2, 2]
// 0 -> 1 -> 3 -> 2 -> 4 -> 2 -> 4 -> keep going like this 
