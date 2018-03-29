/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {       
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
            
            res.add(0,temp);         
        }
        return res;        
    }
}
