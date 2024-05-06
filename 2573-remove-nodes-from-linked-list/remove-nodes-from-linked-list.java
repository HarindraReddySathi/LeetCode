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
        Stack<ListNode> stack = new Stack<>();
        while(temp!=null){

            while(!stack.isEmpty() && stack.peek().val<temp.val){
                stack.pop();
            }
            if(!stack.isEmpty())stack.peek().next=temp;
            stack.push(temp);
            temp = temp.next;
        }
        ListNode prev =null;
        while(!stack.isEmpty()){
            prev = stack.pop();
        }
        return prev;
    }
}