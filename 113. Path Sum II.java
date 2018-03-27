/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
For example:
Given the below binary tree and sum = 22, 
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

//通过Stack记录路径


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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {   
        if(root == null)
            return res;
        
        Stack<Integer> path = new Stack<Integer>();
        
        preOrder(root, sum, path);
        return res;
    }
    
    private void preOrder(TreeNode root, int sum, Stack<Integer> path){
        path.push(root.val);
        if (root.val == sum && root.left == null & root.right == null)
            res.add(new ArrayList<Integer>(path));
        if (root.left != null)
            preOrder(root.left, sum - root.val, path);
        if (root.right != null)
            preOrder(root.right, sum - root.val, path);
        path.pop();
            
    }
}
