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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(head.val+"-");
            head=head.next;
        }
        sb.deleteCharAt(sb.length()-1);
        String fair = sb.toString();
        String rev = sb.reverse().toString();
        if(fair.equals(rev)) return true;
        return false;
    }
}