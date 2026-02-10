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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        // Level order - need bfs for sure
        // just take out everything in level order - reverse alternatives
        List<List<Integer>> res = new ArrayList<>();
        int leftToRight = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> curr = new ArrayList<>();
            for(int i = 0; i<levelSize; i++){
                TreeNode t = queue.poll();
                curr.add(t.val);
                if(t.left!=null) queue.offer(t.left);
                if(t.right!=null) queue.offer(t.right);
            }
            if(leftToRight == -1) Collections.reverse(curr);
            leftToRight *= -1;
            res.add(curr);
        }
        return res;
    }
}