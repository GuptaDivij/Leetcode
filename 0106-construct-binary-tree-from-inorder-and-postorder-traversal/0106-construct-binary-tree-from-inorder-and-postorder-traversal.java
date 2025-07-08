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
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) inorderMap.put(inorder[i], i);
        idx = postorder.length-1;
        return builder(postorder, 0, inorder.length-1, inorderMap);
    }

    public TreeNode builder(int[] postorder, int left, int right, HashMap<Integer, Integer> inorderMap){
        if(left>right) return null;
        TreeNode root = new TreeNode(postorder[idx--]);
        int inorderIdx = inorderMap.get(root.val);
        root.right = builder(postorder, inorderIdx+1, right, inorderMap);
        root.left = builder(postorder, left, inorderIdx-1, inorderMap);
        return root;
    }
}