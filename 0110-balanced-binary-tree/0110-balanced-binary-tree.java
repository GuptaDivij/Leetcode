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
    boolean isBalancedOrNot;
    public boolean isBalanced(TreeNode root) {
        isBalancedOrNot = true;
        isBalancedHelper(root);
        return isBalancedOrNot;
    }

    public int isBalancedHelper(TreeNode root){
        if(root == null) return 0;
        int left = isBalancedHelper(root.left);
        int right = isBalancedHelper(root.right);
        if(Math.abs(left-right) > 1) isBalancedOrNot = false;
        return Math.max(left, right) + 1; // one is to include the current node
    }
}

// 2 height calls - for left and right
// difference in the height is 1 >= if so return true, else I return false.
// base case when it node is null
// O(n) & O(height)