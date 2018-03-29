

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

//方法二，，设立两个头尾指针....

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
