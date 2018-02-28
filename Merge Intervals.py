'''
Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
'''

# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution:
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        ans=[]
        for i in sorted(intervals,key=lambda i:i.start):
            if ans and ans[-1].end >= i.start:
                ans[-1].end=max(ans[-1].end,i.end)
            else:
                ans.append(i)
        return ans
