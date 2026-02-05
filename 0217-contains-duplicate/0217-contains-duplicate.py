class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        checkDuplicates = set()
        for num in nums:
            if num in checkDuplicates:
                return True
            checkDuplicates.add(num)
        return False
        