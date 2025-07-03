// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        for (int end = m + n - 1; end >= 0; end--) {
            if (end2 < 0) break;
            if (end1 >= 0 && nums1[end1] > nums2[end2]) nums1[end] = nums1[end1--];
            else nums1[end] = nums2[end2--];
        }
    }
}