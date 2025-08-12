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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if(pVal>qVal) {
            int temp = pVal;
            pVal = qVal;
            qVal = temp;
        }
        while(root!=null){
            if(root.val>=pVal && root.val<=qVal) return root;
            if (root.val<pVal) root = root.right;
            else root = root.left;
        }
        return null;
    }
}