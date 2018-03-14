#coding:utf-8
#冒泡排序
def bubbleSort(list):
    for i in range(len(list)-1):
        for j in range(len(list)-i-1):
            if list[j] > list[j+1]:
                list[j],list[j+1]=list[j+1],list[j]
//选择排序
def selectSort(list):
    for i in range(len(list)):
        index = i;#index用以标记当前最小数的位置
        for j in range(i+1,len(list)):
            if list[index] > list[j]:
                index=j;
        list[i],list[index] = list[index],list[i]

def quickSort(list):
    if len(list)<2:
        return list
    else:
        midpivot = list[0]
        lessbeforemidpivot = [i for i in list[1:] if i<=midpivot]
        biggerafterpivot = [i for i in list[1:] if i > midpivot]
        finallylist = quickSort(lessbeforemidpivot)+[midpivot]+quickSort(biggerafterpivot)
        return finallylist
