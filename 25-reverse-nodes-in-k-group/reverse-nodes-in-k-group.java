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
        
        if(head==null || head.next==null || k==1) return head;

        ListNode trail = new ListNode(-1);
        trail.next = head;

        int currentSize =1;
        ListNode prevEnd = trail;
        while(head!=null){
            if(currentSize==k){
                prevEnd = reverseGroup(prevEnd,head);
                head = prevEnd;
                currentSize=0;
            }
            head=head.next;
            currentSize++;
        }
        return trail.next;
    }

    public ListNode reverseGroup(ListNode prevEnd, ListNode end){
        
        ListNode nextGroupStart = end.next;
        ListNode start = prevEnd.next;
        ListNode ret = start;
        ListNode prev = nextGroupStart;

        while(start!=nextGroupStart){
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }
        prevEnd.next = prev;
        return ret;

    }
}