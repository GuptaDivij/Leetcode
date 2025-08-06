class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // meadian is the middle value
        int m = nums1.length;
        int n = nums2.length;
        if(n<m) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while(low<=high){
            int partX = low+(high-low)/2;
            int partY = (m+n)/2-partX;
            int l1 = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            int l2 = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            int r1 = partX==m ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY==n ? Integer.MAX_VALUE : nums2[partY];
            if(l1<=r2 && l2<=r1){ // both are in exact middle of the combined sorted arrays
                if((m+n)%2==0) return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                return Math.min(r1,r2);
            } 
            if(l1>r2) high = partX-1;
            else low = partX+1;

        }
        return -1;
    }
}