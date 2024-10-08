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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode cur = new ListNode(-1);
        cur.next = head;
        head = cur;
        cur = head.next;
        ListNode pre = head;
        while(cur!=null){
            
            if(cur.val==val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;

        }
        return head.next;
    }
}