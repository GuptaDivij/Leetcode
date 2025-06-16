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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode tail = null;
        ListNode newHead = null;
        while(curr!=null){
            int ct = 0;
            curr = head;
            while(ct<k && curr!=null){
                curr = curr.next;
                ct++;
            }
            if(ct == k){ 
                ListNode revHead = reverseKNodes(head, k);
                if(newHead == null) newHead = revHead;
                if(tail!=null) tail.next = revHead;
                tail = head;
                head = curr;
            }
        }
        if(tail!=null)tail.next=head;
        return newHead==null?head:newHead;
    }

    public ListNode reverseKNodes(ListNode head, int k){
        // reverse just k nodes
        ListNode curr = head;
        ListNode prev = null;
        while(k>0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}