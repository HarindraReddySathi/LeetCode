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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        int n = len(head);
        //System.out.println(n);
        head=temp;
        if(k==n-k+1) return head;
        int start = (k<n-k+1)?k:n-k+1;
        int end = (k>n-k+1)?k:n-k+1;
        ListNode s = new ListNode(-1);
        int pos =1;
        while(pos!=start){
            head=head.next;
            pos++;
        }
        s = head;
        //System.out.println(head.val);
        while(pos!=end){
            head=head.next;
            pos++;
        }
        int sw = head.val;
        head.val = s.val;
        s.val=sw;
        return temp;
    }

    public int len(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}