// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : we just need to return the first index for which citations[i] is greater than or equal to n-i, because there will n-i papers remaining, and all of the number of citations ahead are gonna be greater as it is ascending. I used binary search to do it in logarithmic time as I can set a mid and keep moving low and high bounds till I find the right index - if nums[mid]>=n-mid, it means this satisfies our condition, n-mid papers are left and all of them will be greater, however, we want the first one to satisfy this as it will maximize n-mid, so we move high to mid-1. If nums[mid]<n-mid it means more papers are left but the citations we recieved are less, so we move low ahead to mid + 1.

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(citations[mid]>=n-mid) high = mid-1;
            else low = mid+1;
        }
        return n-low;
    }
}