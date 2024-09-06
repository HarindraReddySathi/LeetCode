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
        ListNode start = reverse(head);
        ListNode cur = start.next;
        ListNode pre = start;
        int max = start.val;

        while(cur!=null){
            if(cur.val<max){
                pre.next = cur.next;
            }else{
                max = cur.val;
                pre = cur;
            }
            cur = cur.next;
        }
        head = reverse(start);

        return head;
    }

    public ListNode reverse(ListNode head){

        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        head = pre;
        return head;
    }
}