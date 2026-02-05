// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I use the properties of BST -> left<curr<right in an inorder way -> this will always be sorted. So I traverse in order and keep track of the previous seen element, this should always be smaller than next since it is sorted. If at some point this is not true, it means this is one of the swapped elements. The first time it happens we find the larger item stored in prev -> this is first mismatched, we also store the curr as second as it can be the second mismatch. If it happens for the second time, curr is now a smaller value which was supposed to be seen before, so this is the second misplaced element. After running this I simply swap these two nodes.

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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = null;
        inOrder(root);
        swap(first, second);
    }

    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root; 
        inOrder(root.right);
    }

}