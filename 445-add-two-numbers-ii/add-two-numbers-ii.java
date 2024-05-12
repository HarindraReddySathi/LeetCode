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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseALinkedList(l1);
        l2 = reverseALinkedList(l2);
        ListNode head = addTwoNumbersReverseOrder(l1,l2);
        return reverseALinkedList(head);
    }

    public ListNode addTwoNumbersReverseOrder(ListNode l1, ListNode l2){
        
        ListNode first_list = l1;
        ListNode second_list = l2;
        ListNode first_prev = null;
        ListNode second_prev = null;
        int carry =0;
        while(l1!=null || l2!=null || carry!=0){
            int x = l1!=null ? l1.val : 0;
            int y = l2!=null ? l2.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            sum = sum%10;
            if(l1==null && l2==null){
                if(first_prev!=null){
                    first_prev.next = new ListNode(1);
                    return first_list;
                }
                second_prev.next = new ListNode(1);
                return second_list;
            }
            if(l1!=null) l1.val = sum;
            if(l2!=null) l2.val = sum;
            first_prev = l1;
            second_prev = l2;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return first_prev!=null ? first_list : second_list;
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