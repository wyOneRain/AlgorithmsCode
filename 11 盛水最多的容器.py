class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxArea = 0
        left,right = 0,len(height)-1
        while left < right:
            maxArea = max(maxArea,(right-left) * min(height[left],height[right]))
            if height[left] > height[right]:
                right = right - 1
            else:
                left = left + 1
        return maxArea


            