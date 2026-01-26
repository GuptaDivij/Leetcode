class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                res[stack.pop()] = nums[i];
            }
        }
        return res;
    }
}

// Stack -> if smaller than peek, add it, else while not there put it!