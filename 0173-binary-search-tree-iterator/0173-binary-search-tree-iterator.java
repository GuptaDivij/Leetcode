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
class BSTIterator {

    TreeNode prev;
    TreeNode head;

    public BSTIterator(TreeNode root) {
        prev = null;
        inorder(root);
        head = prev;
    }
    
    public int next() {
        if (head != null) {
            TreeNode next = head;
            head = head.right;
            return next.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        return head != null;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.right);

            root.right = prev;
            prev = root;

            inorder(root.left);
            root.left = null;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */