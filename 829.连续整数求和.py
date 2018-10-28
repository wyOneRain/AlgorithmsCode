'''
解题思路：
假设有k个连续的数字，它们的和为N。最小的k个连续的数字之和是1 + 2 + 3 + … + k。
从1开始的连续k个数字之和不一定等于N。
但可能存在一个整数i，使得i + (i + 1) + (i + 2) + (i + 3) + … + (i + k) = N。
我们把这个等式稍微变换一下就有1 + 2 + 3 + … + k + i * (k + 1)  = N
也就是N - (1 + 2 + 3 + … + k) = i * (k + 1)。

这个公式告诉我们，如果有k个连续的数字的和等于N，那么一定存在一个整数i，
N 减去1 + 2 + 3 + … + k的差等于i * (k + 1)。也就是说N减去1 + 2 + 3 + … + k的差一定能被 (k + 1) 整除。
'''
class Solution:
    def consecutiveNumbersSum(self, N):
        """
        :type N: int
        :rtype: int
        """
        ans = 1
        for k in range(1,N):
            s = k * (k + 1) // 2
            if s < N:
                if (N - s) % (k + 1) == 0:
                    ans += 1
            else:
                break
        return ans

