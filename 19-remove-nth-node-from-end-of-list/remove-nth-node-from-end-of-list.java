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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode itr = head;
        int size=0;
        while(itr!=null){
            size++;
            itr=itr.next;
        }
        itr = head;
        n = size-n-1;
        if(n==-1) return head.next;
        int i=0;
        while(i<n){
            itr=itr.next;
            i++;
        }
        itr.next=itr.next.next;
        return head;
    }
}