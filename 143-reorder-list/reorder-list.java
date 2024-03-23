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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //System.out.println(slow.val);
        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next=null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }

        ListNode l2 = prev;
        ListNode l1 = head;

        while(l2!=null){
            ListNode temp2 = l2.next;
            ListNode temp1 = l1.next;
            l1.next=l2;
            l2.next = temp1;
            l1=temp1;
            l2=temp2;
        }
    }
}