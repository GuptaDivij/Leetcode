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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while(prev!=null){
            if(prev.val!=head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}

// Basically go to the mid, count the number of elements. Reverse it from mid to end. Now move ahead each point with 2 linkedlists
// 1 2 2 2 1