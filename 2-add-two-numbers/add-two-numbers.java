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
        ListNode first_list = l1;
        ListNode second_list = l2;
        ListNode first_prev = null;
        ListNode second_prev = null;
        int carry =0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            carry = sum/10;
            sum = sum%10;
            l1.val = sum;
            l2.val = sum;
            first_prev = l1;
            second_prev = l2;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = l1.val+carry;
            carry = sum/10;
            sum = sum%10;
            l1.val = sum;
            first_prev = l1;
            l1 = l1.next;
        }
        if(l2==null){
            if(carry!=0) first_prev.next = new ListNode(carry);
            return first_list;
        }
        while(l2!=null){
            int sum = l2.val+carry;
            carry = sum/10;
            sum = sum%10;
            l2.val = sum;
            second_prev = l2;
            l2 = l2.next;
        }
        if(carry!=0) second_prev.next = new ListNode(carry);
        return second_list;
    }
}