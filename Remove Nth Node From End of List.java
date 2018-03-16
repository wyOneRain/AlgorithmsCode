/*
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

//思想类似于快慢指针
//此快慢指针的移动过程，相当于一个固定窗口大小为 n 的滑动窗口；
//因为要删除倒数第n个节点，即要获取n前一个节点，所以移动窗口大小应为n+1;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //因为可能会删除第一个节点,创建一个在头结点之前的开始节点
        ListNode newHead = new ListNode(0);
        newHead.next=head;
        
        //快慢指针
        ListNode slow = newHead,fast=newHead;
        
        //快指针移动n次
        for(int i = 0 ; i < n;i++)
            fast = fast.next;
            
        //快指针移动到末尾时，慢指针即移动到倒数n+1位置
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        return newHead.next;
        
    }
}
