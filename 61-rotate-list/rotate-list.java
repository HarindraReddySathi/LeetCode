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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) return head;
        ListNode temp = head;
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        k = k%size;
        if(k==0) return temp;
        head=temp;
        int pos =0;
        while(pos!=size-k-1){
            head=head.next;
            pos++;
        }
        ListNode root = head.next;
        ListNode itr = head.next;
        head.next =null;
        while(itr.next!=null){
            itr=itr.next;
        }
        itr.next = temp;
        return root;
    }
}