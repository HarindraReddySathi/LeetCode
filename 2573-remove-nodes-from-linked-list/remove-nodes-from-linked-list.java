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
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){

            while(!stack.isEmpty() && stack.peek()<temp.val){
                stack.pop();
            }
            stack.push(temp.val);
            temp = temp.next;
        }
        ListNode prev =null;
        while(!stack.isEmpty()){
            ListNode cur = new ListNode(stack.pop());
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}