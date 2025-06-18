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
    private int height;
    public List<Integer> rightSideView(TreeNode root) {
        height = -1;
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }
    public void rightView(TreeNode root, int currHeight, List<Integer> list){
        if(root == null) return;
        if(currHeight>height){
            list.add(root.val);
            height = currHeight;
        }
        rightView(root.right, currHeight+1, list);
        rightView(root.left, currHeight+1, list);
    }
}