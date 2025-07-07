/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean helper(TreeNode root, long maxRight, long minLeft){
        if(root==null) return true;
        if(root.left!=null && root.left.val>=root.val) return false;
        if(root.right!=null && root.right.val<=root.val) return false;
        if(root.val >= maxRight || root.val <= minLeft) return false;
        boolean left = helper(root.left, root.val, minLeft);
        boolean right = helper(root.right, maxRight, root.val);
        return left && right;
    }
}