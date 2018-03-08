'''
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
'''

class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        if len(nums) < 3:
            return False
        
        result=nums[0]+nums[1]+nums[2]
        for i in range(len(nums)-2):
            j,k = i + 1,len(nums) - 1
            while j < k:
                temp_sum = nums[i] + nums[j] + nums[k]
                if temp_sum == target:
                    return temp_sum
                if abs(temp_sum-target)<abs(result-target):
                    result=temp_sum
                if temp_sum > target:
                    k -= 1
                else:
                    j += 1
        return result

        
