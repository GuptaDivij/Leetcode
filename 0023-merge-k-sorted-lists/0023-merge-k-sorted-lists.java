// Time Complexity : O(nlogk) n is total elements, k is lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I used the merge function which merges 2 lists, I do this in binary manner - I use a merge factor which merges list[i] with list[i+merge], and then increments i with merge*2 - this makes sure that all lists are covered. Eg for k = 6, I first merge 0 and 1; 2 and 3; 4 and 5. Then I merge 0 (it already has 1) and 2 (it already has 3). So now, 0123 are merged at index 0, now next iteration I merge 0 and 4 (which already has 5) and then I stop. At this point all lists are merged and stored at index 0.

// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k==0) return null;
        int merge = 1;
        while (merge < k) {
            for (int i = 0; i < k - merge; i += merge * 2) {
                lists[i] = mergeLists(lists[i], lists[i + merge]); 
            }
            merge = merge * 2;
        }
        return lists[0];
    }

    public ListNode mergeLists(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = first;
                first = curr.next.next;
            }
            curr = curr.next;
        }
        if (first == null) curr.next = second;
        else curr.next = first;
        return dummy.next;
    }
}