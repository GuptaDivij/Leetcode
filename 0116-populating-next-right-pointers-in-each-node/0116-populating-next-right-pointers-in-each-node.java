// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : At each level, I set the next of the next levels, i.e., at root, I set the next of 2nd level, and so on. So, first, I set curr.left.next to be curr.right and then if curr has a next already set up from the previous level, I set curr.right.next to be curr.next.left and then move in the level by moving curr to its next. 

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node left = root;
        while(left.left != null) {
            Node curr = left;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}