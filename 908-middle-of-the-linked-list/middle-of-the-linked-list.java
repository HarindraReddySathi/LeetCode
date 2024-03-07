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
    public ListNode middleNode(ListNode head) {
        if(head.next ==null) return head;
        ListNode hare = head.next.next;
        ListNode tortoise = head.next;

        while(hare!=null && hare.next!=null && hare!=tortoise){
            hare = hare.next.next;
            tortoise=tortoise.next;
        }
        if(hare==tortoise) return null;
        return tortoise;
    }
}