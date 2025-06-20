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
    private int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        // we find the maximum on the left side
        int gainFromLeft = Math.max(helper(root.left), 0);
        // we find the maximum on the right side
        int gainFromRight = Math.max(helper(root.right), 0);
        // ans is max of current ans or left + right + mid
        ans = Math.max(ans, gainFromLeft + gainFromRight + root.val);
        // for finding left and right, we return max of left or right
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }
}