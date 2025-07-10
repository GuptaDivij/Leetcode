class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nextHead = new ListNode(0, head);
        ListNode slow = nextHead;
        ListNode fast = nextHead;
        for(int i = 1; i<=n; i++) {
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return nextHead.next;
    }
}
