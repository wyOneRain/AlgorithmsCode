/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99]) 
*/

/*
定义子问题f(k) ：长度为k时各位均不同数字的个数。
f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [首个因数是9，因为数字不能从0开始].
*/


class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;  
        if(n==1) return 10;  
        int val = 9, ans = 10;  
        for(int i = 2; i <= n; i++)  
        {  
            val *= (9-i+2);  
            ans += val;  
        }  
        return ans;  
    }  
}
