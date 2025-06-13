class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Find total size
        ListNode curr = head;
        int total = 0;
        while (curr != null) {
            curr = curr.next;
            total++;
        }

        // Step 2: Calculate index from beginning
        int removingIndex = total - n + 1;

        // Step 3: If removing head
        if (removingIndex == 1) {
            return head.next;
        }

        // Step 4: Traverse to node just before the one to remove
        curr = head;
        for (int i = 0; i < removingIndex - 2; i++) {
            curr = curr.next;
        }

        // Step 5: Remove the nth node
        curr.next = curr.next.next;

        return head;
    }
}
