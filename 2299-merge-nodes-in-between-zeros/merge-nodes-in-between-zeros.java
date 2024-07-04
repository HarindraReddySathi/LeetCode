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
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        boolean isStart = false;
        while(head!=null){
            if(head.val!=0){
                if(isStart){
                    cur.next = new ListNode();
                    cur = cur.next;
                    isStart = false;
                }
                cur.val += head.val;
            }else{
                isStart = true;
            }
            head = head.next;
        }
        return root.next;
    }
}