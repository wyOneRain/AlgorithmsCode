/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

//层次遍历类似于队列先进先出

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        
        if (root == null)
            return res;
        
        Queue<TreeNode> path = new LinkedList<TreeNode>();
        path.offer(root);
        
        while(!path.isEmpty()){
            
            List<Integer> temp = new LinkedList<Integer>();
            int num = path.size();
            
            for(int i = 0 ;i < num; i++){
                if(path.peek().left != null)
                    path.offer(path.peek().left);
                if(path.peek().right != null)
                    path.offer(path.peek().right);
                temp.add(path.poll().val);
            }
            res.add(temp);         
        }
        
        return res;
    }
}
