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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        goodNode(root, root.val);
        return count;
    }
    public void goodNode(TreeNode node, int rootVal){
        if(node == null) return;
        if(node.val>=rootVal) count++;
        int newMax = Math.max(rootVal, node.val);
        goodNode(node.left, newMax);
        goodNode(node.right, newMax);
    }
}