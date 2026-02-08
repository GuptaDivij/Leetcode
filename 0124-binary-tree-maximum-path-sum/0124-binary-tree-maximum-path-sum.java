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
    int max;
    public int maxPathSum(TreeNode root) {
        // avoid negatives -> issue is at root then we won't be able to find left and right sum
        if(root == null) return 0;
        max = Integer.MIN_VALUE;
        find(root);
        return max;
    }
    public int find(TreeNode root){
        if(root==null) return 0;
        int l = find(root.left);
        int r = find(root.right);
        int curr = Math.max(root.val, Math.max(root.val + Math.max(l, r), root.val + l + r));
        max = Math.max(max, curr);
        // cannot send 2 way left and right in sendback
        return Math.max(root.val, root.val + Math.max(l, r));
    }
}

// at root, left = 9
// max = 9