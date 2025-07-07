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
    private int p;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrder = new HashMap<>();
        p=0;
        for(int i = 0; i<inorder.length; i++){
            inOrder.put(inorder[i],i);
        }
        return helper(preorder, 0, inorder.length-1, inOrder);
    }
    private TreeNode helper(int[] preorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        if (inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[p++]); // create a new node. 
        int inorderIndex = inorderMap.get(root.val); // index at which this point is in inorder

        root.left = helper(preorder, inStart, inorderIndex-1, inorderMap); // all elements to the left
        root.right = helper(preorder, inorderIndex+1, inEnd, inorderMap); // all elements to the right

        return root;
    }
}