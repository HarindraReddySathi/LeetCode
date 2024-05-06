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
    public ListNode removeNodes(ListNode head) {
        head = reverse( head);
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        int high = 0;
        while(head!=null){
            if(head.val>=high){
                prev=prev.next;
                if(head.val>high) high = head.val;
            }else{
                prev.next = head.next;
            }
            head = head.next;
        }
        return reverse( root.next);
    }

    public ListNode reverse(ListNode head){

        ListNode temp = null;
        ListNode next = null;
        while(head.next!=null){
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        head.next = temp;
        return head;
    }
}