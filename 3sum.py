'''
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
'''

class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums=sorted(nums)
        ans=[]
        if len(nums)<3:
            return ans          
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            j,k=i+1,len(nums)-1
            while j<k:
                temp_sum=nums[i]+nums[j]+nums[k]
                if temp_sum==0:
                    ans.append([nums[i],nums[j],nums[k]])
                if temp_sum>0:
                    k-=1
                else:
                    j+=1
        return list(set(tuple(i) for i in ans))
