/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int a = 0;
        int b = 0;
        while(curr!=null){
            curr=curr.next;
            a++;
        }
        curr = headB;
        while(curr!=null){
            curr=curr.next;
            b++;
        }
        if(a>=b){
            while(a!=b){
                headA = headA.next;
                a--;
            }
        }
        else{
            while(a!=b){
                headB = headB.next;
                b--;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}