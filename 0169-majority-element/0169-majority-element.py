class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        candidate = nums[0]
        for i in range(len(nums)):
            if count==0:
                candidate = nums[i]
            if nums[i]==candidate:
                count = count+1
            else:
                count = count-1
        return candidate

        