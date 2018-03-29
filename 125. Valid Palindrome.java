/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. 
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 
*/


//简单粗暴的先将字符串变成小写，然后遍历分类到res,在判断是否是回文字符串

class Solution {
    public boolean isPalindrome(String s) {
       
       if(s.length() <= 1)
            return true;
        
        StringBuffer res = new StringBuffer();
       
        for(char c : s.toLowerCase().toCharArray()){
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
                res.append(c);
        }
        int i = 0,j = res.length()-1;
        while(i<=j)
            if( res.charAt(i++) != res.charAt(j--) )
                return false;
        return true;
    }
}
