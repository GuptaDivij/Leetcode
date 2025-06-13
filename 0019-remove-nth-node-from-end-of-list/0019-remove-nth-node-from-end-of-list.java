class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // one pass
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        int i = 0;
        while (i <= n) { 
            fast = fast.next;
            i++;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
