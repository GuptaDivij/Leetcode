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
    private int ct;
    public int averageOfSubtree(TreeNode root) {
        ct = 0; 
        dfs(root);
        return ct;
    }

    // Time complexity = O(n) - n is the number of elements
    // Space complexity = O(h) - h is the height of the tree
    public int[] dfs(TreeNode root){
        if(root==null) return new int[2]; // [0,0]
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] curr = new int[2];
        // [sum, numOfElements]
        curr[0] = left[0] + right[0] + root.val;
        curr[1] = left[1] + right[1] + 1;
        // curr[0] should never be 0 because when it is 0 for base case, I return, then minimum I add 1
        if(curr[0]/curr[1] == root.val) ct++;
        return curr;
    }
}