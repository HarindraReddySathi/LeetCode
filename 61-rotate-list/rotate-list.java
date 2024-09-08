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
        ListNode temp = head;
        ListNode pre = null;
        int size = findSize(head);
        if(size ==0) return head;
        k = k%size;
        if(k==0) return head;
        int rounds = size -k;
        while(rounds>0){
            pre = head;
            head = head.next;
            rounds--;
        }
        pre.next = null;
        pre = head;

        while(head.next!=null){
            head = head.next;
        }
        head.next = temp;
        return pre;
    }

    public int findSize(ListNode head){

        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}