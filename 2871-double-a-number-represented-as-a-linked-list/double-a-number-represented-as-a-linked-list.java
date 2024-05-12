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
    public ListNode doubleIt(ListNode head) {
        
        ListNode start = head;
        head = reverseALinkedList(head);
        ListNode begin = head;
        int carry = 0;
        ListNode prev = null;
        while(head!=null){
            int cur_Val = head.val*2+carry;
            head.val = cur_Val%10;
            carry = cur_Val/10;
            prev = head;
            head=head.next;
        }
        if(carry!=0) prev.next = new ListNode(1);
        return reverseALinkedList(begin);
    }

    public ListNode reverseALinkedList(ListNode head){

        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}