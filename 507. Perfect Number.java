/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself. 
Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not. 

Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        
        int sum = 1;
        
        for (int x = 2; x * x <= num; x++)
        {
            if (num % x == 0)
            {
                sum += x;
                sum += num / x;
            }
        }
        
        return sum == num;


    }
}
