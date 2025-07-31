// Time Complexity : O(nlogk) for the heap
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used a min heap to store k elements, as soon as the size gets more than k, i pop the mininum element out. At end, the k largest elements are in the heap and the popped one is the smallest among them, i.e., the kth largest element.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) heap.remove();
        }
        return heap.peek();
    }
}