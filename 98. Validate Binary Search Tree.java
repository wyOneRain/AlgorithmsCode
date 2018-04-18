/*
Given a binary tree, determine if it is a valid binary search tree (BST). 
Assume a BST is defined as follows: 
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        Stack<TreeNode> path = new Stack<TreeNode>();
        TreeNode cur = null;
        
        while(root != null || !path.isEmpty()){
            while (root != null){
                path.push(root);
                root = root.left;
            }
            root = path.pop();
            if(cur != null && root.val <= cur.val) return false;
            cur = root;
            root = root.right;
        }
        return true;
    }
}
