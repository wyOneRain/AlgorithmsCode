# -*- coding: utf-8 -*-
'''
思路来源：http://blog.csdn.net/power721/article/details/8216619
'''

import math

def is_prime(n):
    for i in range(2,int(math.sqrt(n))+1):
        if n%i==0:
            return False
    return True

def not_division(n):
    return lambda x:x%n>0

def find_s(start,end):
    l = [i for i in range(start,end)]
    temp=l
    ans=[]
    for i in range(start,end):
        if (i-start)*(i-start)<end:
            if is_prime(l[i-start]):
                ans.append(l[i-start])
            temp=list(filter(lambda x:x%i>0,temp))
        else:
            break
    ans = ans+temp
    return ans



# prc=[i for i in range(2,30)]
# print(list(filter(lambda x:x%2>0,prc)))
print(list(find_s(2,100)))
