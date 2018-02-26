#For example,
#Given 1->2->3->4, you should return the list as 2->1->4->3. 

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        p = head
        while p.next!=None:
            p.val,p.next.val=p.next.val,p.val
            p=p.next
            if p.next!=None:
                p=p.next
        return head
