'''
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
Example: 
Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
'''

#本来解题思路是对除最大值的每个数+1,在判断平衡
#但其实换个思路，同时也是所有数字都减小到最小值

class Solution:
    def minMoves(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        min_num = min(nums)
        res = 0
        for num in nums:
            res += num - min_num
        return res
