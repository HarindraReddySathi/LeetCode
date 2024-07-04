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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = head;
        ListNode prev = head;
        head = head.next;
        while(head!=null){
            if(head.val!=0){
                prev.val += head.val;
            }else{
                if(head.next ==null) prev.next = null;
                else{
                    prev=prev.next;
                    prev.val = 0;
                }
            }
            head = head.next;
        }
        return ans;
    }
}