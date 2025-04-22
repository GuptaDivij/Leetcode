class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxWindow = new int[nums.length-k+1];
        int left = 0;
        for(int i = 0; i<nums.length; i++){
            // make sure deque is in decreasing order
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

            // left most is not in window anymore
            if (left > deque.peekFirst()) {
                deque.pollFirst();
            }

            // if i (end) reaches enough length for window, we add
            if(i+1>=k){
                maxWindow[left] = nums[deque.peekFirst()];
                left++;
            }
        }
        return maxWindow;
    }
}