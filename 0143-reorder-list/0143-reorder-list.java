/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is now the midpoint - reverse from slow to end
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode curr = head;
        while (prev.next!=null){
            ListNode temp1 = curr.next;
            ListNode temp2 = prev.next;
            curr.next = prev;
            prev.next = temp1;
            curr = temp1;
            prev = temp2;
        }
    }
}