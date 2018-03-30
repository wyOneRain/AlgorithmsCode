


/*
Given a binary tree 
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Note: 
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

//实际上层次遍历的一个变种，明白for循环的执行顺序，判断是否到同一层次的最后一个节点

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        
        Queue<TreeLinkNode> path = new LinkedList<TreeLinkNode>();
        path.offer(root);
        
        while(!path.isEmpty()){
            int size = path.size();
            
            for(int i = 0; i < size; i++){
                if(path.peek().left != null)
                    path.offer(path.peek().left);
                if(path.peek().right != null)
                    path.offer(path.peek().right);
                
                TreeLinkNode cur = path.poll();
                
                if(i == size - 1)
                    cur.next = null;
                else
                    cur.next = path.peek();
            }
        }
    }
}


//评论区一位大佬的解法

public void connect(TreeLinkNode root) {
    while(root != null && root.left != null) {
        TreeLinkNode cur = root;
        while(cur != null) {
            cur.left.next = cur.right;
            cur.right.next = cur.next == null ? null : cur.next.left;
            cur = cur.next;
        }
        root = root.left;
    }
}
