/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 
Example:
Input: "cbbd"

Output: "bb"
*/

//leetcode死活不通过，绝望:(
//解法思想：因为回文字符串是以中心轴对称的;
//所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等,那么只需要对0到len-1的下标都做此操作，
//就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，
//即"abcba"与"abba"2种类型，因此需要在代码编写时都做判断。

class Solution {
    
    private static int index = 0;//回文子串的起始位置
    private static int maxLen = 0;//回文子串的最大长度
    
    public String longestPalindrome(String s) {  
        int len=s.length();
        if(len<2) return s;
        
        for(int i=0;i<len;i++){
            extendPalindrome(s,i,i);//回文子串是奇数的情况
            extendPalindrome(s,i,i+1);//回文子串是偶数的情况
        }

        return s.substring(index, index + maxLen);
    }
    
    private  void extendPalindrome(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
       
        start++;
        end--;
        if(maxLen < end - start){
            index = start;
            maxLen = end - start + 1;
        }
    }
}
